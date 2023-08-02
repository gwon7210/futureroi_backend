package com.web.futureroi.service;

import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.domain.dayToDoWork.DayToDoWokr;
import com.web.futureroi.dto.dayDiary.DayDiaryReqDto;
import com.web.futureroi.dto.dayDiary.DayDiaryResDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.dto.dayToDoWork.UpdateDayToDoWorkReqDto;
import com.web.futureroi.repository.DayToDoWorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DayToDoWorkService {

    private final DayToDoWorkRepository dayToDoWorkRepository;

    public List<DayToDoWorkResDto> getDayToDoWorks(String uuid, String date) throws BaseException {

        List<DayToDoWorkResDto> dayToDoWorkResDtos = dayToDoWorkRepository.findByUuidAndDate(uuid,date).stream()
                .map(DayToDoWorkResDto::new)
                .collect(Collectors.toList());

        if(dayToDoWorkResDtos == null || dayToDoWorkResDtos.size()<1){
            throw new BaseException(ApiCode.DATA_NOT_FOUND);
        }

        return dayToDoWorkResDtos;
    }

    public int saveDayToDoWorks(String uuid, List<DayToDoWorkReqDto> dayToDoWorkReqDtos) {

        List<DayToDoWokr> dayToDoWokrs = dayToDoWorkReqDtos.stream().
                map(resDto -> DayToDoWokr.builder()
                        .uuid(uuid)
                        .content(resDto.getContent())
                        .dayToDoListOrder(resDto.getDayToDoListOrder())
                        .build()).collect(Collectors.toList());

        dayToDoWorkRepository.saveAll(dayToDoWokrs);

        return dayToDoWokrs.size();
    }

    public int updateDayToDoWorks(String uuid, List<UpdateDayToDoWorkReqDto> updateDayToDoWorkReqDtos) {

        List<DayToDoWokr> dayToDoWokrs = updateDayToDoWorkReqDtos.stream().
                map(resDto -> DayToDoWokr.builder()
                        .dayToDoWorkId(resDto.getDayToDoWorkId())
                        .uuid(uuid)
                        .content(resDto.getContent())
                        .dayToDoListOrder(resDto.getDayToDoListOrder())
                        .isFinished(resDto.getIs_finished())
                        .build()).collect(Collectors.toList());

        dayToDoWorkRepository.saveAll(dayToDoWokrs);

        return dayToDoWokrs.size();
    }



}
