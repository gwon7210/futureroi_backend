package com.web.futureroi.service;

import com.web.futureroi.domain.member.Member;
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

//    @Transactional
//    public Member modifyMemberInfo(MemberModifyReqDto reqDto) {
//        return memberRepository.save(getMember(reqDto.getMemberId()).modify(reqDto));
//    }

    public Member registerMember(String uuid, String authProvider, String email) {
        Member member = Member.builder()
                .uuid(uuid)
                .email(email)
                .authProvider(authProvider)
                .role(Role.ROLE_USER)
                .build();

        return memberRepository.save(member);

    }

    public Member getMember(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + memberId));
    }

    public Member findByEmailAndAuthProvider(String email, String provider){
        return memberRepository.findByEmailAndAuthProvider(email,provider).orElse(null);
    }





}
