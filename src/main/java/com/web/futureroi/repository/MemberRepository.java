package com.web.futureroi.repository;


import com.web.futureroi.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUuid(String uuid);

    Optional<Member> findByEmail(String email);
    Optional<Member> findByEmailAndAuthProvider(String email,String authProvider);

}
