package com.web.futureroi.dto.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.futureroi.domain.notice.Notice;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Schema(description = "공지사항 리스트 응답Dto")
@Getter
public class NoticeResDto {
    @Schema(description = "공지사항id")
    private Long noticeId;

    @Schema(description = "공지사항 제목")
    private String title;
    @Schema(description = "공지사항 내용")
    private String content;

    @Schema(description = "공지사항 작성 날짜 ex)23/06/11")
    @JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")
    private LocalDateTime registerDate;

    public NoticeResDto(Notice entity){
        this.noticeId = entity.getNoticeId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
//        this.registerDate = entity.getRegisterDate();
    }
}
