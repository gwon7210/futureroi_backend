package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.auth.TokenInfo;
import com.web.futureroi.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "auth", description = "인증 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController extends CommController {

    private final AuthService authService;

    @PostMapping("/login/{provider}")
    public ResponseEntity socialLogin(@RequestHeader(value="Authorization") String socialToken, @PathVariable String provider) throws BaseException {
        TokenInfo tokenInfo = authService.socialLogin(socialToken, provider);
        return SuccessReturn(tokenInfo);
    }


}
