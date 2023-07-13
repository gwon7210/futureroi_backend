package com.web.futureroi.dto.member;

import com.web.futureroi.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "맴버 정보 수정 요청 DTO")
@Getter
@Setter
public class MemberModifyReqDto {

    @NotNull
    @Schema(description = "맴버 키", hidden = true)
    private Long memberId;
    @Schema(description = "닉네임", nullable = true, example = "noah")
    private String nickname;
    @Schema(description = "위치", nullable = true, example = "seoul")
    private String location;

    public Member toEntity() {
        return Member.builder()
//                .memberId(memberId)
//                .nickname(nickname)
//                .location(location)
                .build();
    }
}
