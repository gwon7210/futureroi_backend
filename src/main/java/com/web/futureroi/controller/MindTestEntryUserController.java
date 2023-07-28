package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.dto.mindTestUser.MindTestEntryUserReqDto;
import com.web.futureroi.service.MindTestEntryUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "mindtest", description = "심리검사 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/mindtestuser")
public class MindTestEntryUserController extends CommController {

    @Autowired
    private MindTestEntryUserService mindTestEntryUserService;

    @Operation(summary = "심리검사 질문 사용자 저장", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MindTestEntryUserReqDto.class)))})
    @PostMapping
    public ResponseEntity saveMindTestEntryUser(@AuthenticationPrincipal User user, @RequestBody List<MindTestEntryUserReqDto> reqDtoList){
        String uuid = user.getUsername();
        return SuccessReturn(mindTestEntryUserService.saveMindTestEntryUser(uuid, reqDtoList));
    }


}
