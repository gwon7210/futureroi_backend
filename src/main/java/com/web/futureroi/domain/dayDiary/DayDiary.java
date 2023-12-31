package com.web.futureroi.domain.dayDiary;

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
public class DayDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayDiaryId;

    private String uuid;

    private String content;

    private String date;

}
