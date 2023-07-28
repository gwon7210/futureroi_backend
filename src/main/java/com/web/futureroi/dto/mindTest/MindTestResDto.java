package com.web.futureroi.dto.mindTest;

import com.web.futureroi.domain.mindTest.MindTest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Schema(description = "심리검사 질문 조회 응답Dto")
@Getter
@Setter
public class MindTestResDto {

    @Schema(description = "Id")
    private Long mindTestId;
    @Schema(description = "심리 타입")
    private String type;
    @Schema(description = "배치 순서")
    private int mindTestOrder;

    @Schema(description = "검사 질문 리스트")
    private List<MindTestEntryResDto> mindTestEntries;

    public MindTestResDto(MindTest entity){
        this.mindTestId = entity.getMindTestId();
        this.type = entity.getType();
        this.mindTestOrder = entity.getMindTestOrder();
    }

}
