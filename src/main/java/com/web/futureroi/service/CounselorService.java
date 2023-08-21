package com.web.futureroi.service;

import com.web.futureroi.common.code.ApiCode;
import com.web.futureroi.common.exception.BaseException;
import com.web.futureroi.dto.counselor.CounselorResDto;
import com.web.futureroi.dto.dayToDoWork.DayToDoWorkResDto;
import com.web.futureroi.repository.CounselorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CounselorService {

    private final CounselorRepository counselorRepository;


    public List<CounselorResDto> findCounselors(String name) throws BaseException {

        List<CounselorResDto> CounselorResDtos = counselorRepository.findAll().stream()
                .map(CounselorResDto::new)
                .collect(Collectors.toList());

        if (CounselorResDtos == null || CounselorResDtos.size() < 1) {
            throw new BaseException(ApiCode.DATA_NOT_FOUND);
        }

        return CounselorResDtos;
    }


}
