package com.web.futureroi.domain.dayToDoWork;

import com.web.futureroi.dto.dayToDoWork.UpdateDayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.UpdateIsFinishedReqDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DayToDoWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayToDoWorkId;
    private String uuid;
    private String content;
    private String isFinished;
    private String dayToDoWorkOrder;
    private String date;

    public DayToDoWork update(UpdateDayToDoWorkReqDto reqDto) {
        this.dayToDoWorkId = reqDto.getDayToDoWorkId();
        this.content = reqDto.getContent();
        return this;
    }

    public DayToDoWork updateIsFinished(UpdateIsFinishedReqDto reqDto) {
        this.dayToDoWorkId = reqDto.getDayToDoWorkId();
        this.isFinished = reqDto.getIsFinished();
        return this;
    }

}
