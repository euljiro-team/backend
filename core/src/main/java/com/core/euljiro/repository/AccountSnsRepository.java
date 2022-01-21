package com.core.euljiro.repository;

import com.core.euljiro.domain.AccountSns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountSnsRepository extends JpaRepository<AccountSns, Long>, JpaSpecificationExecutor<AccountSns> {

}
