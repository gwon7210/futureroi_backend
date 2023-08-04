package com.web.futureroi.controller;


import com.web.futureroi.common.CommController;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.dto.dayToDoWork.UpdateDayToDoWorkReqDto;
import com.web.futureroi.service.DayToDoWorkService;
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

import java.util.List;

@Tag(name = "DayToDoWork", description = "매일 할일 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/daytodowork")
public class DayToDoWorkController extends CommController {

    private final DayToDoWorkService dayToDoWorkService;

    @Operation(summary = "매일 할일 조회", description = "매일 할일 list를 반환합니다.", responses = {@ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DayToDoWorkResDto.class))))})
    @GetMapping("/{date}")
    public ResponseEntity findDayToDoWorks(@AuthenticationPrincipal User user, @PathVariable String date) throws BaseException {
    String uuid = user.getUsername();
    return SuccessReturn(dayToDoWorkService.getDayToDoWorks(uuid,date));}

    @Operation(summary = "사용자 매일 할일 저장", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = DayToDoWorkReqDto.class)))})
    @PostMapping("/{date}")
    public ResponseEntity saveDayToDoWorks(@AuthenticationPrincipal User user, @PathVariable String date, @RequestBody List<DayToDoWorkReqDto> reqDtos) {
        String uuid = user.getUsername();
        return SuccessReturn(dayToDoWorkService.saveDayToDoWorks(uuid, date, reqDtos));
    }

    @Operation(summary = "사용자 매일 할일 수정", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = DayToDoWorkReqDto.class)))})
    @PostMapping()
    public ResponseEntity updateDayToDoWorks(@AuthenticationPrincipal User user, @RequestBody List<UpdateDayToDoWorkReqDto> reqDtos) {
        String uuid = user.getUsername();
        return SuccessReturn(dayToDoWorkService.updateDayToDoWorks(uuid, reqDtos));
    }



}
