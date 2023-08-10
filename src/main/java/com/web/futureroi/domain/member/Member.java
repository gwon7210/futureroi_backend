package com.web.futureroi.domain.member;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import com.web.futureroi.dto.member.MemberIsFirstChatbotReqDto;
import com.web.futureroi.dto.member.MemberModifyReqDto;
import com.web.futureroi.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends RegisterDateBaseTimeEntity {

    @Id
    private String uuid;

    private String email;

    private String authProvider;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String job;
    private String gender;
    private String birth;
    private String nickName;
    private String isFirstChatbot;


    public Member modify(MemberModifyReqDto reqDto) {
        this.uuid = reqDto.getUuid();
        this.job = reqDto.getJob();
        this.gender = reqDto.getGender();
        this.birth = reqDto.getBirth();
        this.nickName = reqDto.getNickName();
        return this;
    }


    public Member modifyIsFirstChatbot(MemberIsFirstChatbotReqDto reqDto) {
        this.uuid = reqDto.getUuid();
        this.isFirstChatbot = reqDto.getIsFirstChatbot();
        return this;
    }

}
