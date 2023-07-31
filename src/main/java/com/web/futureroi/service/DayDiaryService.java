package com.web.futureroi.service;


import com.web.futureroi.domain.dayDiary.DayDiary;
import com.web.futureroi.domain.dayToDoWork.DayToDoWokr;
import com.web.futureroi.domain.member.Member;
import com.web.futureroi.dto.dayDiary.DayDiaryReqDto;
import com.web.futureroi.dto.dayDiary.DayDiaryResDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.enums.Role;
import com.web.futureroi.repository.DayDiaryRepository;
import com.web.futureroi.repository.DayToDoWorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DayDiaryService {

    private final DayDiaryRepository dayDiaryRepository;


    public DayDiaryResDto findDayDiary(String uuid, String date){
        return new DayDiaryResDto(dayDiaryRepository.findByUuidAndDate(uuid,date));

    }


    @Transactional
    public Long saveDayDiary(String uuid, DayDiaryReqDto dayDiaryReqDto) {

        dayDiaryRepository.deleteAllByUuidAndDate(uuid, dayDiaryReqDto.getDate());

        DayDiary dayDiary = DayDiary.builder()
                .uuid(uuid)
                .content(dayDiaryReqDto.getContent())
                .date(dayDiaryReqDto.getDate())
                .build();

        Long Id = dayDiaryRepository.save(dayDiary).getDayDiaryId();

        return Id;
    }

}
