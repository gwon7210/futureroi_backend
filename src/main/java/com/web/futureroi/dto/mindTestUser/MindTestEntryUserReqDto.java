package com.web.futureroi.dto.mindTestUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 심리검사 저장Dto")
@Getter
@Setter
public class MindTestEntryUserReqDto {

    @Schema(description = "mindTest Id")
    private Long mindTestId;

    @Schema(description = "mindTest Entry Id")
    private Long mindTestEntryId;
}
