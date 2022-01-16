package com.core.euljiro.common.repository;

import com.core.euljiro.EnumMaster;
import com.core.euljiro.common.domain.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer>, JpaSpecificationExecutor<AccountRole> {
    List<AccountRole> findByRoleType(EnumMaster.RoleType roleType);
}
