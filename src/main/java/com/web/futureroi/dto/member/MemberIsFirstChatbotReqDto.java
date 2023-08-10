package com.web.futureroi.dto.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "맴버 정보 수정 요청 DTO")
@Getter
@Setter
public class MemberIsFirstChatbotReqDto {

    @Schema(description = "맴버 키", hidden = true)
    private String uuid;

    @Schema(description = "챗봇 최초 실행 여부")
    private String isFirstChatbot;


}
