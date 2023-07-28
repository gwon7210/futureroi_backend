package com.web.futureroi.controller;

import com.web.futureroi.common.CommController;
import com.web.futureroi.dto.mindTest.MindTestResDto;
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
import org.springframework.web.bind.annotation.*;

@Tag(name = "mindtest", description = "심리검사 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/mindtest")
public class MindTestController extends CommController {

    @Autowired
    private MindTestService mindTestService;

    @Operation(summary = "심리검사 질문 조회",
            responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MindTestResDto.class))))})
    @GetMapping
    public ResponseEntity findMindTests(){
        return SuccessReturn(mindTestService.findMindTests());
    }



}
