package com.web.futureroi.dto.member;

import com.web.futureroi.domain.member.Member;
import com.web.futureroi.enums.Role;
import lombok.Getter;

@Getter
public class MemberInfoResDto {

    private String uuid;
    private String email;

    private String authProvider;

    private Role role;

    private String job;

    private String gender;

    private String birth;

    public MemberInfoResDto(Member member){
        this.uuid = member.getUuid();
        this.email = member.getEmail();
        this.authProvider = member.getAuthProvider();
        this.role = member.getRole();
        this.job = member.getJob();
        this.gender = member.getGender();
        this.birth = member.getBirth();

    }
}
