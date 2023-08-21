package com.web.futureroi.repository;

import com.web.futureroi.domain.userConfig.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
}
