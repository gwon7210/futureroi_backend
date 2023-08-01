package com.web.futureroi.controller;


import com.web.futureroi.common.CommController;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.dayDiary.DayDiaryReqDto;
import com.web.futureroi.dto.dayDiary.DayDiaryResDto;
import com.web.futureroi.dto.sample.SampleResDto;
import com.web.futureroi.service.DayDiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Tag(name = "daydiary", description = "사용자 매일 일기 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/daydiary")
public class DayDiaryController extends CommController {

    private final DayDiaryService dayDiaryService;

    @Operation(summary = "사용자 매일 일기 조회",responses = {@ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DayDiaryResDto.class))))})
    @GetMapping("/{date}")
    public ResponseEntity findDayDiary(@AuthenticationPrincipal User user, @PathVariable String date) throws BaseException {
        String uuid = user.getUsername();
        return SuccessReturn(dayDiaryService.findDayDiary(uuid,date));
    }

    @Operation(summary = "사용자 매일 일기 저장", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = DayDiaryReqDto.class)))})
    @PostMapping()
    public ResponseEntity saveDayDiary(@AuthenticationPrincipal User user, @RequestBody DayDiaryReqDto reqDto) {
        String uuid = user.getUsername();
        return SuccessReturn(dayDiaryService.saveDayDiary(uuid, reqDto));
    }
}

