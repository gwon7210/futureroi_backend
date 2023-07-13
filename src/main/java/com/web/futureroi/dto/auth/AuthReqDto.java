package com.web.futureroi.dto.auth;

import lombok.Getter;

@Getter
public class AuthReqDto {

    private String refreshToken;
    private String accessToken;
}
