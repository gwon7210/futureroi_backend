package com.web.futureroi.controller;


import com.web.futureroi.common.CommController;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.dto.sample.SampleResDto;
import com.web.futureroi.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DayToDoWork", description = "매일 할일 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/daytodowork")
public class DayToDoWorkController extends CommController {

    private final SampleService sampleService;

@Operation(summary = "매일 할일 조회", description = "매일 할일 list를 반환합니다.", responses = {
        @ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DayToDoWorkResDto.class))))})
    @GetMapping("")
    public ResponseEntity findDayToDoWorks(){
        return SuccessReturn(sampleService.getNotices());
    }
}
