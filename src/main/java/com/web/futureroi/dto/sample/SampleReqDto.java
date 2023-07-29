package com.web.futureroi.dto.sample;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 심리검사 저장Dto")
@Getter
@Setter
public class SampleReqDto {

    @Schema(description = "심리검사 엔트리 Id")
    private Long mindTestEntryId;



}
