package com.core.euljiro.repository;

import com.core.euljiro.domain.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer>, JpaSpecificationExecutor<AccountRole> {

}
