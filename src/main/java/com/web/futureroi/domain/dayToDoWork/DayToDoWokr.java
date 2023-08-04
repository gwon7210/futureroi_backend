package com.web.futureroi.domain.dayToDoWork;

import com.web.futureroi.common.RegisterDateBaseTimeEntity;
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
public class DayToDoWokr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayToDoWorkId;
    private String uuid;
    private String content;
    private String isFinished;
    private String dayToDoListOrder;
    private String date;
}
