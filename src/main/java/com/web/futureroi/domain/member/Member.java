package com.web.futureroi.domain.member;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import com.web.futureroi.dto.member.MemberModifyReqDto;
import com.web.futureroi.enums.AuthProvider;
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
//
//    public Member modify(MemberModifyReqDto reqDto) {
//        this.nickname = reqDto.getNickname();
//        this.location = reqDto.getLocation();
//        return this;
//    }


}
