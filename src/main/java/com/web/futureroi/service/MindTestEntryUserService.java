package com.web.futureroi.service;

import com.web.futureroi.domain.mindTest.MindTestEntryUser;
import com.web.futureroi.dto.mindTestUser.MindTestEntryUserReqDto;
import com.web.futureroi.repository.MindTestEntryUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MindTestEntryUserService {

    private final MindTestEntryUserRepository mindTestEntryUserRepository;


    @Transactional
    public int saveMindTestEntryUser(String uuid, List<MindTestEntryUserReqDto> reqDtoList){

        mindTestEntryUserRepository.deleteAllByUuid(uuid);

        List<MindTestEntryUser> mindTestEntryUsers = reqDtoList.stream().
                map(resDto -> MindTestEntryUser.builder()
                        .uuid(uuid)
                        .mindTestId(resDto.getMindTestId())
                        .mindTestEntryId(resDto.getMindTestEntryId())
                        .build()).collect(Collectors.toList());

        mindTestEntryUserRepository.saveAll(mindTestEntryUsers);

        return mindTestEntryUsers.size();
    }



}
