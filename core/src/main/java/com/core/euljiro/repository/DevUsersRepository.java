package com.core.euljiro.repository;

import com.core.euljiro.domain.DevUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DevUsersRepository extends JpaRepository<DevUsers, Integer>, JpaSpecificationExecutor<DevUsers> {

}
