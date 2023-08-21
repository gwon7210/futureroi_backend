package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.counselor.CounselorResDto;
import com.web.futureroi.dto.mindTest.MindTestResDto;
import com.web.futureroi.service.CounselorService;
import com.web.futureroi.service.MindTestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "counselor", description = "상담자 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/counselor")
public class CounselorController extends CommController {

    @Autowired
    private CounselorService counselorService;

    @Operation(summary = "상담자 조회",
            responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CounselorResDto.class))))})
    @GetMapping
    public ResponseEntity findCounselors(String name) throws BaseException {
        return SuccessReturn(counselorService.findCounselors(name));
    }



}
