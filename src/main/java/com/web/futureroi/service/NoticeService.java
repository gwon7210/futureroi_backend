package com.web.futureroi.service;


import com.web.futureroi.dto.notice.NoticeResDto;
import com.web.futureroi.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResDto> getNotices(){
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "registerDate")).stream()
                .map(NoticeResDto::new)
                .collect(Collectors.toList());
    }
}
