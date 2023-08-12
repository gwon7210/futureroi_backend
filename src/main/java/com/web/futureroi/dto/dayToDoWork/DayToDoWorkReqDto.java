package com.web.futureroi.dto.dayToDoWork;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "사용자 오늘 할일 저장Dto")
@Getter
public class DayToDoWorkReqDto {

    @Schema(description = "내용")
    private String content;

    @Schema(description = "순서")
    private String dayToDoWorkOrder;

    @Schema(description = "완료 여부")
    private String isFinished = "0";

}
