package com.core.euljiro.repository;

import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer>, JpaSpecificationExecutor<AccountRole> {
    List<AccountRole> findByRoleType(EnumMaster.RoleType roleType);

    List<AccountRole> findByAccount_AccountId(Integer accountId);

    List<AccountRole> findByAccount_Email(String email);
}
