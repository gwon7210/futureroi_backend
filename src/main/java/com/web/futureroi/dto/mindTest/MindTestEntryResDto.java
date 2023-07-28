package com.web.futureroi.dto.mindTest;

import com.web.futureroi.domain.mindTest.MindTestEntry;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;


@Schema(description = "심리검사 질문 조회 응답Dto")
@Getter
public class MindTestEntryResDto {

    @Schema(description = "Id")
    private Long mindTestEntryId;
    @Schema(description = "배치 순서")
    private Long mindTestEntryOrder;
    @Schema(description = "질문")
    private String question;

    public MindTestEntryResDto(MindTestEntry entity){
        this.mindTestEntryId = entity.getMindTestEntryId();
        this.mindTestEntryOrder = entity.getMindTestEntryOrder();
        this.question = entity.getQuestion();
    }

}
