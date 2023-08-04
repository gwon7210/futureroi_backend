package com.web.futureroi.service;

import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.domain.dayToDoWork.DayToDoWork;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.dto.dayToDoWork.UpdateDayToDoWorkReqDto;
import com.web.futureroi.repository.DayToDoWorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Transactional
    public int saveDayToDoWorks(String uuid, String date, List<DayToDoWorkReqDto> dayToDoWorkReqDtos) {
        dayToDoWorkRepository.deleteAllByUuidAndDate(uuid, date);
        List<DayToDoWork> dayToDoWorks = dayToDoWorkReqDtos.stream().
                map(resDto -> DayToDoWork.builder()
                        .uuid(uuid)
                        .content(resDto.getContent())
                        .dayToDoWorkOrder(resDto.getDayToDoWorkOrder())
                        .date(date)
                        .isFinished("0")
                        .build()).collect(Collectors.toList());

        dayToDoWorkRepository.saveAll(dayToDoWorks);

        return dayToDoWorks.size();
    }
//date값 받지 않고 처리하기
    public int updateDayToDoWorks(String uuid, String date,  List<UpdateDayToDoWorkReqDto> updateDayToDoWorkReqDtos) {

        List<DayToDoWork> dayToDoWorks = updateDayToDoWorkReqDtos.stream().
                map(resDto -> DayToDoWork.builder()
                        .dayToDoWorkId(resDto.getDayToDoWorkId())
                        .uuid(uuid)
                        .date(date)
                        .content(resDto.getContent())
                        .dayToDoWorkOrder(resDto.getDayToDoWorkOrder())
                        .build()).collect(Collectors.toList());

        dayToDoWorkRepository.saveAll(dayToDoWorks);

        return dayToDoWorks.size();
    }



}
