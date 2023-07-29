package com.web.futureroi.service;


import com.web.futureroi.domain.member.Member;
import com.web.futureroi.dto.sample.SampleResDto;
import com.web.futureroi.enums.Role;
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
public class SampleService {

    private final NoticeRepository noticeRepository;

    public List<SampleResDto> getNotices(){
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "registerDate")).stream()
                .map(SampleResDto::new)
                .collect(Collectors.toList());
    }

//    public Member registerMember(String uuid, String authProvider, String email) {
//        Member member = Member.builder()
//                .uuid(uuid)
//                .email(email)
//                .authProvider(authProvider)
//                .role(Role.ROLE_USER)
//                .build();
//
//        return noticeRepository.save(member);
//    }

}
