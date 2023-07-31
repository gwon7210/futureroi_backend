package com.web.futureroi.dto.dayDiary;

import com.web.futureroi.domain.dayDiary.DayDiary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "공지사항 리스트 응답Dto")
@Getter
public class DayDiaryResDto {

    @Schema(description = "ID")
    private Long dayDiaryId;
    @Schema(description = "내용")
    private String content;
    @Schema(description = "날짜")
    private String date;


    public DayDiaryResDto(DayDiary entity){
        this.dayDiaryId = entity.getDayDiaryId();
        this.content = entity.getContent();
        this.date = entity.getDate();
    }

}
