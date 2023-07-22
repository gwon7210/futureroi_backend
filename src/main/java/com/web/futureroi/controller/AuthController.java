package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.auth.AuthReqDto;
import com.web.futureroi.dto.auth.TokenInfo;
import com.web.futureroi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "소셜 로그인", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenInfo.class)))})
    @PostMapping("/login/{provider}")
    public ResponseEntity socialLogin(@RequestHeader(value="Authorization") String socialToken, @PathVariable String provider) throws BaseException {
        TokenInfo tokenInfo = authService.socialLogin(socialToken, provider);
        return SuccessReturn(tokenInfo);
    }

    @Operation(summary = "로그인 테스트", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenInfo.class)))})
    @PostMapping("/login/test")
    public ResponseEntity socialLogintest() throws BaseException {
        TokenInfo tokenInfo = authService.socialLoginTest();
        return SuccessReturn(tokenInfo);
    }

    @Operation(summary = "토큰 재발급", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenInfo.class)))})
    @PostMapping("/regenerateToken")
    public ResponseEntity regenerateToken(@RequestBody AuthReqDto authReqDto) throws BaseException {
        return SuccessReturn(authService.regenerateToken(authReqDto));
    }


}
