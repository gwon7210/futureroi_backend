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

    @Schema(description = "완료 여부")
    private String is_finished;

    @Schema(description = "순서")
    private String dayToDoListOrder;
}
