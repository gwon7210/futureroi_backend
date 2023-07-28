package com.web.futureroi.service;

import com.web.futureroi.domain.mindTest.MindTest;
import com.web.futureroi.repository.MindTestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MindTestServiceTest {

    @Mock
    private MindTestRepository mindTestRepository;

    @Test
    void findMindTestAll() {


        List<MindTest> mindTestList =  mindTestRepository.findAll();
        System.out.println(mindTestList);

    }
}