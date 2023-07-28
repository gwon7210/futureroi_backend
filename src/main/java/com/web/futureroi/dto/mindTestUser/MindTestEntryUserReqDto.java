package com.web.futureroi.dto.mindTestUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 심리검사 저장Dto")
@Getter
@Setter
public class MindTestEntryUserReqDto {

    @Schema(description = "심리검사 엔트리 Id")
    private Long mindTestEntryId;

//    public MindTestEntryUserReqDto(MindTestEntryUser entity){
//        this.mindTestEntryId = entity.getMind_test_entry_id();
//    }

}
