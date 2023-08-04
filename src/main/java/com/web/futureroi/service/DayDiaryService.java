package com.web.futureroi.service;


import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.domain.dayDiary.DayDiary;
import com.web.futureroi.dto.dayDiary.DayDiaryReqDto;
import com.web.futureroi.dto.dayDiary.DayDiaryResDto;
import com.web.futureroi.repository.DayDiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class DayDiaryService {

    private final DayDiaryRepository dayDiaryRepository;


    public DayDiaryResDto findDayDiary(String uuid, String date) throws BaseException {
        return new DayDiaryResDto(dayDiaryRepository.findByUuidAndDate(uuid,date).orElseThrow(() -> new BaseException(ApiCode.DATA_NOT_FOUND)));
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
