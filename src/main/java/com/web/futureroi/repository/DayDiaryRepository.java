package com.web.futureroi.repository;

import com.web.futureroi.domain.dayDiary.DayDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayDiaryRepository extends JpaRepository<DayDiary, Long> {

    DayDiary findByUuidAndDate(String uuid, String date);

    void deleteAllByUuidAndDate(String uuid, String date);


}
