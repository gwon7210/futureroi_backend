package com.web.futureroi.dto.dayDiary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "매일 일기 저장Dto")
@Getter
@Setter
public class DayDiaryReqDto {

    @Schema(description = "내용")
    private String content;

    @Schema(description = "날짜", format = "????.??.??")
    private String date;
}
