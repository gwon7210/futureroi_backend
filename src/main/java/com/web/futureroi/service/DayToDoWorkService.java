//package com.web.futureroi.service;
//
//
//import com.web.futureroi.domain.dayToDoWork.DayToDoWokr;
//import com.web.futureroi.dto.dayToDoWork.DayDiaryReqDto;
//import com.web.futureroi.dto.dayToDoWork.DayDiaryResDto;
//import com.web.futureroi.repository.DayToDoWorkRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class DayToDoWorkService {
//
//    private final DayToDoWorkRepository dayToDoWorkRepository;
//
//    public List<DayDiaryResDto> getDayToDoWorks(String uuid, String day){
//        return dayToDoWorkRepository.findByUuid().stream()
//                .map(DayDiaryResDto::new)
//                .collect(Collectors.toList());
//    }
//
//    public int save(String uuid, List<DayDiaryReqDto> dayToDoWorkReqDtos) {
//
//        List<DayToDoWokr> dayToDoWokrs = dayToDoWorkReqDtos.stream().
//                map(resDto -> DayToDoWokr.builder()
//                        .uuid(uuid)
//                        .content(resDto.getContent())
//                        .isFinished(resDto.getIsFinished())
//                        .dayToDoListOrder(resDto.getDayToDoListOrder())
//                        .build()).collect(Collectors.toList());
//
//        dayToDoWorkRepository.saveAll(dayToDoWokrs);
//
//        return dayToDoWokrs.size();
//    }
//
//}
