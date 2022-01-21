package com.core.euljiro.repository;

import com.core.euljiro.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    Optional<Account> findByUsername(String userName);

    Optional<Account> findByEnglishName(String englishName);

    Account findByUserId(String userId);

    Account findByEmail(String email);

    Page<Account> findByUsernameContains(String accountName, Pageable pageable);
}
