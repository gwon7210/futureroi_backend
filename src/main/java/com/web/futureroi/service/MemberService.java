package com.web.futureroi.service;

import com.web.futureroi.domain.member.Member;
import com.web.futureroi.dto.member.MemberInfoResDto;
import com.web.futureroi.dto.member.MemberIsFirstChatbotReqDto;
import com.web.futureroi.dto.member.MemberModifyReqDto;
import com.web.futureroi.enums.Role;
import com.web.futureroi.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member modifyMemberInfo(MemberModifyReqDto reqDto) {
        return memberRepository.save(getMember(reqDto.getUuid()).modify(reqDto));
    }

    public Member modifyIsFirstChatbot(MemberIsFirstChatbotReqDto reqDto) {
        return memberRepository.save(getMember(reqDto.getUuid()).modifyIsFirstChatbot(reqDto));
    }

    public Member registerMember(String uuid, String authProvider, String email) {
        Member member = Member.builder()
                .uuid(uuid)
                .email(email)
                .authProvider(authProvider)
                .role(Role.ROLE_USER)
                .build();

        return memberRepository.save(member);

    }

    public Member getMember(String uuid){
        return memberRepository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. uuid=" + uuid));
    }

    public Member findByEmailAndAuthProvider(String email, String provider){
        return memberRepository.findByEmailAndAuthProvider(email,provider).orElse(null);
    }

    public MemberInfoResDto findMemberInfo(String uuid){
        return new MemberInfoResDto(getMember(uuid));
    }



}
