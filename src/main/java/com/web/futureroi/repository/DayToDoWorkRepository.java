package com.web.futureroi.repository;

import com.web.futureroi.domain.dayToDoWork.DayToDoWokr;
import com.web.futureroi.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayToDoWorkRepository extends JpaRepository<DayToDoWokr, Long> {

    Optional<DayToDoWokr> findByUuid(String uuid);
}
