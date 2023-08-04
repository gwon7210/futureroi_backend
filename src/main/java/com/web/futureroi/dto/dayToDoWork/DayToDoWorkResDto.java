package com.web.futureroi.dto.dayToDoWork;

import com.web.futureroi.domain.dayToDoWork.DayToDoWork;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;


@Schema(description = "공지사항 리스트 응답Dto")
@Getter
public class DayToDoWorkResDto {

    @Schema(description = "ID")
    private Long dayToDoWorkId;

    @Schema(description = "UUID")
    private String uuid;

    @Schema(description = "내용")
    private String content;

    @Schema(description = "완료 여부")
    private String is_finished;

    @Schema(description = "순서")
    private String dayToDoWorkOrder;

    @Schema(description = "날짜")
    private String date;


    public DayToDoWorkResDto(DayToDoWork entity){
        this.dayToDoWorkId = entity.getDayToDoWorkId();
        this.uuid = entity.getIsFinished();
        this.content = entity.getContent();
        this.is_finished = entity.getIsFinished();
        this.dayToDoWorkOrder = entity.getDayToDoWorkOrder();
        this.date = entity.getDate();
    }
}
