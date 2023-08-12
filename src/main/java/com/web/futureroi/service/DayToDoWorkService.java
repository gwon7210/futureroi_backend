package com.web.futureroi.service;

import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.domain.dayToDoWork.DayToDoWork;
import com.web.futureroi.domain.member.Member;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.dto.dayToDoWork.UpdateDayToDoWorkReqDto;
import com.web.futureroi.dto.dayToDoWork.UpdateIsFinishedReqDto;
import com.web.futureroi.repository.DayToDoWorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DayToDoWorkService {

    private final DayToDoWorkRepository dayToDoWorkRepository;

    public List<DayToDoWorkResDto> getDayToDoWorks(String uuid, String date) throws BaseException {

        List<DayToDoWorkResDto> dayToDoWorkResDtos = dayToDoWorkRepository.findByUuidAndDate(uuid, date).stream()
                .map(DayToDoWorkResDto::new)
                .collect(Collectors.toList());

        if (dayToDoWorkResDtos == null || dayToDoWorkResDtos.size() < 1) {
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
                        .isFinished(resDto.getIsFinished())
                        .build()).collect(Collectors.toList());

        dayToDoWorkRepository.saveAll(dayToDoWorks);

        return dayToDoWorks.size();
    }

    @Transactional
    public int updateDayToDoWorks(List<UpdateDayToDoWorkReqDto> updateDayToDoWorkReqDtos) {

        List<Long> dayToDoWorkIds = updateDayToDoWorkReqDtos.stream()
                .map(UpdateDayToDoWorkReqDto::getDayToDoWorkId)
                .collect(Collectors.toList());

        List<DayToDoWork> dayToDoWorks = dayToDoWorkRepository.findAllById(dayToDoWorkIds);

        for (DayToDoWork dayToDoWork : dayToDoWorks) {
            for (UpdateDayToDoWorkReqDto updateDayToDoWorkReqDto : updateDayToDoWorkReqDtos) {
                if (dayToDoWork.getDayToDoWorkId() == updateDayToDoWorkReqDto.getDayToDoWorkId()) {
                    dayToDoWork.update(updateDayToDoWorkReqDto);
                }
            }
        }

        dayToDoWorkRepository.saveAll(dayToDoWorks);

        return dayToDoWorks.size();
    }

    @Transactional
    public DayToDoWork updateIsFinished(UpdateIsFinishedReqDto updateIsFinishedReqDtos) throws BaseException {
        return dayToDoWorkRepository.save(getDayToDoWorks(updateIsFinishedReqDtos.getDayToDoWorkId()).updateIsFinished(updateIsFinishedReqDtos));


    }

    public DayToDoWork getDayToDoWorks(Long id) throws BaseException {
        return dayToDoWorkRepository.findById(id)
                .orElseThrow(() -> new BaseException(ApiCode.DATA_NOT_FOUND));
    }

}