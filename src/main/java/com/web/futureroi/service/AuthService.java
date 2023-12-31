package com.web.futureroi.service;

import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.domain.member.Member;
import com.web.futureroi.dto.auth.AuthReqDto;
import com.web.futureroi.dto.auth.TokenInfo;
import com.web.futureroi.enums.Role;
import com.web.futureroi.jwt.JwtExpireTime;
import com.web.futureroi.jwt.JwtTokenProvider;
import com.web.futureroi.lib.SocialLoginUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final RedisTemplate redisTemplate;
    private final MemberService memberService;
    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final String TYPE_ACCESS = "access";
    private static final String TYPE_REFRESH = "refresh";

    @Value("${jwt.token.secret-key}")
    private String secretKey;

    @Autowired
    SocialLoginUtils socialLoginUtils;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public TokenInfo socialLogin(String socialToken, String provider) throws BaseException {

        String email = getMemberInfoByAccessToken(socialToken, provider);

        if(email == null){
            throw new BaseException(ApiCode.INVALID_SOCIAL_USER);
        }

        //가입 유저 체크
        Member member = memberService.findByEmailAndAuthProvider(email,provider);

        //회원정보가 없다면 가입시켜준다.
        if(member==null){
            String uuid = UUID.randomUUID().toString();
            member = memberService.registerMember(uuid, provider, email);
        }

        Date now = new Date();
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.name()));

        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        String accessToken = Jwts.builder()
                .setSubject(member.getUuid())
                .claim(AUTHORITIES_KEY, authorities)
                .claim("type", TYPE_ACCESS)
                .setIssuedAt(now)   //토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + JwtExpireTime.ACCESS_TOKEN_EXPIRE_TIME))  //토큰 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        //Generate RefreshToken
        String refreshToken = Jwts.builder()
                .claim("type", TYPE_REFRESH)
                .setIssuedAt(now)   //토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + JwtExpireTime.REFRESH_TOKEN_EXPIRE_TIME)) //토큰 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        TokenInfo tokenInfo =  TokenInfo.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpirationTime(JwtExpireTime.ACCESS_TOKEN_EXPIRE_TIME)
                .refreshToken(refreshToken)
                .refreshTokenExpirationTime(JwtExpireTime.REFRESH_TOKEN_EXPIRE_TIME)
                .build();

        redisTemplate.opsForValue()
                .set("RT:" + member.getUuid(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    @Transactional
    public TokenInfo socialLoginTest() {

        Date now = new Date();
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.name()));

        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        String accessToken = Jwts.builder()
                .setSubject("77d52f69-affb-4afd-b7ca-7dce9d435bfb")
                .claim(AUTHORITIES_KEY, authorities)
                .claim("type", TYPE_ACCESS)
                .setIssuedAt(now)   //토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + JwtExpireTime.TEST_ACCESS_TOKEN_EXPIRE_TIME))  //토큰 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        //Generate RefreshToken
        String refreshToken = Jwts.builder()
                .claim("type", TYPE_REFRESH)
                .setIssuedAt(now)   //토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + JwtExpireTime.REFRESH_TOKEN_EXPIRE_TIME)) //토큰 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        TokenInfo tokenInfo =  TokenInfo.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpirationTime(JwtExpireTime.ACCESS_TOKEN_EXPIRE_TIME)
                .refreshToken(refreshToken)
                .refreshTokenExpirationTime(JwtExpireTime.REFRESH_TOKEN_EXPIRE_TIME)
                .build();

        redisTemplate.opsForValue()
                .set("RT:" + "77d52f69-affb-4afd-b7ca-7dce9d435bfb", tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    public TokenInfo regenerateToken(AuthReqDto authReqDto) throws BaseException {

        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(authReqDto.getRefreshToken())) {
            throw new BaseException(ApiCode.EXPIRED_REFRESH_TOKEN);
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(authReqDto.getAccessToken());

        // 3. Redis 에서 User email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = (String)redisTemplate.opsForValue().get("RT:" + authentication.getName());

        // (추가) 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if(ObjectUtils.isEmpty(refreshToken)) {
            throw new BaseException(ApiCode.EXPIRED_REFRESH_TOKEN);
        }

        if(!refreshToken.equals(authReqDto.getRefreshToken())) {
            throw new BaseException(ApiCode.INVALID_RT);
        }

        // 4. 새로운 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication.getName(), authentication.getAuthorities());

        // 5. RefreshToken Redis 업데이트
        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }



    public String getMemberInfoByAccessToken(String accessToken, String provider) throws BaseException {

        String email = null;
        try {
            switch (provider) {
                case "kakao":
                    email = socialLoginUtils.getKakaoInfo(accessToken);
                    break;
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return email;
    }






}
