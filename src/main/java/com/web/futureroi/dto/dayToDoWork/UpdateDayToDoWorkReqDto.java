package com.web.futureroi.dto.dayToDoWork;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "사용자 오늘 할일 저장Dto")
@Getter
public class UpdateDayToDoWorkReqDto {

    @Schema(description = "ID")
    private Long dayToDoWorkId;

    @Schema(description = "내용")
    private String content;

}
