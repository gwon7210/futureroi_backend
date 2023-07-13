package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.dto.member.MemberModifyReqDto;
import com.web.futureroi.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Tag(name = "member", description = "맴버 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController extends CommController {

    private final MemberService memberService;
//
//    @Operation(summary = "맴버 정보 업데이트", responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MemberModifyReqDto.class)))})
//    @PutMapping()
//    public ResponseEntity modifyMemberInfo(@AuthenticationPrincipal User user, @RequestBody MemberModifyReqDto reqDto){
//        reqDto.setMemberId(Long.valueOf((user.getUsername())));
//        return SuccessReturn(memberService.modifyMemberInfo(reqDto));
//    }


//    @Operation(summary = "맴버 정보 조회", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MemberInfoResDto.class)))})
//    @GetMapping("/info")
//    public ResponseEntity findMemberInfo(@AuthenticationPrincipal User user){
//        long memberId = Long.valueOf((user.getUsername()));
//        return SuccessReturn(memberService.findMemberInfo(memberId));
//    }




}
