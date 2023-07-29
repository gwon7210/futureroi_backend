package com.web.futureroi.dto.dayToDoList;

import com.web.futureroi.domain.dayToDoList.DayToDoList;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;


@Schema(description = "공지사항 리스트 응답Dto")
@Getter
public class DayToDoListResDto {

    @Schema(description = "일기 내용")
    private String content;

    @Schema(description = "완료 여부")
    private String isFinished;

    @Schema(description = "순서")
    private String dayToDoListOrder;


    public DayToDoListResDto(DayToDoList entity){
        this.content = entity.getContent();
        this.isFinished = entity.getIsFinished();
        this.dayToDoListOrder = entity.getDayToDoListOrder();
    }
}
