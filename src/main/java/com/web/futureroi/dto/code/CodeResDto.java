package com.web.futureroi.dto.code;

import com.web.futureroi.domain.code.Code;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "코드 조회 응답Dto")
@Getter
public class CodeResDto {

    @Schema(description = "코드")
    private String code;
    @Schema(description = "코드 그룹")
    private String codeGroup;

    @Schema(description = "코드 아이디")
    private int codeId;
    @Schema(description = "코드 이름")
    private String codeName;
    @Schema(description = "코드 순서")
    private int codeOrderNo;
    @Schema(description = "코드 사용 여부")
    private int isUse;
    @Schema(description = "코드 설명")
    private String codeDescription;

    @Schema(description = "코드 등록일")
    private String registerDate;


    public CodeResDto(Code entity){
        this.code = entity.getCode();
        this.codeGroup = entity.getCodeGroup();
        this.codeId = entity.getCodeId();
        this.codeName = entity.getCodeName();
        this.codeOrderNo = entity.getCodeOrderNo();
        this.isUse = entity.getIsUse();
        this.codeDescription = entity.getCodeDescription();
//        this.registerDate = String.valueOf(entity.getRegisterDate());
    }

}
