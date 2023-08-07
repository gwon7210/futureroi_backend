package com.web.futureroi.repository;

import com.web.futureroi.domain.dayToDoWork.DayToDoWork;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DayToDoWorkRepository extends JpaRepository<DayToDoWork, Long> {

    List<DayToDoWork> findByUuidAndDate(String uuid, String Date);

    void deleteAllByUuidAndDate(String uuid, String date);


}
