package com.web.futureroi.repository;

import com.web.futureroi.domain.mindTest.MindTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MindTestRepository extends JpaRepository<MindTest, Long> {

    List<MindTest> findByIsUse(String isUse);


}
