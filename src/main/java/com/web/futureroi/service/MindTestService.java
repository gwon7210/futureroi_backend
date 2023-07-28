package com.web.futureroi.service;

import com.web.futureroi.domain.mindTest.MindTest;
import com.web.futureroi.domain.mindTest.MindTestEntry;
import com.web.futureroi.dto.mindTest.MindTestEntryResDto;
import com.web.futureroi.dto.mindTest.MindTestResDto;
import com.web.futureroi.repository.MindTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MindTestService {

    private final MindTestRepository mindTestRepository;


    // TODO: 2023/07/28 dsl이나 조인문으로 리팩토링 필요
    @Transactional
    public List<MindTestResDto> findMindTests(){

        List<MindTest> mindTests = mindTestRepository.findByIsUse("1");

        List<MindTestResDto> mindTestResDtos = new ArrayList<>();

        for(MindTest mt : mindTests){

            MindTestResDto mindTestResDto = new MindTestResDto(mt);

            List<MindTestEntry> mindTestEntries = mt.getMindTestEntries();
            List<MindTestEntryResDto> mindTestEntryResDtos =  mindTestEntries.stream()
                    .filter(entry -> entry.getIsUse().equals("1"))
                    .map(MindTestEntryResDto::new)
                    .collect(Collectors.toList());

            mindTestResDto.setMindTestEntries(mindTestEntryResDtos);

            mindTestResDtos.add(mindTestResDto);
        }
        return mindTestResDtos;
    }




}
