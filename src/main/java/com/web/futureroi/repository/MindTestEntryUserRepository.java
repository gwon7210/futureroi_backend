package com.web.futureroi.repository;

import com.web.futureroi.domain.mindTest.MindTestEntryUser;
import com.web.futureroi.domain.mindTest.MindTestEntryUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MindTestEntryUserRepository extends JpaRepository<MindTestEntryUser, MindTestEntryUserId> {

    List<MindTestEntryUser> deleteAllByUuid(String uuid);


}
