package com.web.futureroi.dto.counselor;

import com.web.futureroi.domain.counselor.Counselor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "상담사 조회 응답Dto")
@Getter
@Setter
public class CounselorResDto {

    @Schema(description = "Id")
    private Long id;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "협회 이름")
    private String organization;
    @Schema(description = "상담사 사진")
    private String imageUrl;
    @Schema(description = "소개글")
    private String introduction;
    @Schema(description = "경력 사항")
    private String career;
    @Schema(description = "순서")
    private Integer orderNo;

    public CounselorResDto(Counselor entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.organization = entity.getOrganization();
        this.imageUrl = entity.getImageUrl();
        this.introduction = entity.getIntroduction();
        this.career = entity.getCareer();
        this.orderNo = entity.getOrderNo();
    }

}
