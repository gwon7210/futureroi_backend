package com.web.futureroi.jwt;

public class JwtExpireTime {

    public static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L; //30분

    public static final long TEST_ACCESS_TOKEN_EXPIRE_TIME = 1000L * 20;  //20초
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;     //7일

//    public static final long ACCESS_TOKEN_EXPIRE_TIME = 30000;               //30분


}
