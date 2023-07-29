package com.web.futureroi.dto.dayToDoList;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "사용자 심리검사 저장Dto")
@Getter
public class DayToDoListReqDto {


    @Schema(description = "content")
    private String content;

    @Schema(description = "완료 여부")
    private String isFinished;

    @Schema(description = "순서")
    private String dayToDoListOrder;
}
