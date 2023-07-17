package com.web.futureroi.dto.member;

import com.web.futureroi.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "맴버 정보 수정 요청 DTO")
@Getter
@Setter
public class MemberModifyReqDto {

    @NotNull
    @Schema(description = "맴버 키", hidden = true)
    private String uuid;
    @Schema(description = "직업", nullable = true)
    private String job;
    @Schema(description = "성별", nullable = true)
    private String gender;
    @Schema(description = "생일", nullable = true)
    private String birth;

    public Member toEntity() {
        return Member.builder()
                .uuid(uuid)
                .job(job)
                .gender(gender)
                .birth(birth)
                .build();
    }
}
