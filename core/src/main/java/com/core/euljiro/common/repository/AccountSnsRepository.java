package com.core.euljiro.common.repository;

import com.core.euljiro.EnumMaster;
import com.core.euljiro.common.domain.AccountSns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSnsRepository extends JpaRepository<AccountSns, Long> {
    AccountSns findBySnsEmail(String snsEmail);

    AccountSns findByProviderTypeAndSnsEmail(EnumMaster.ProviderType providerType, String snsEmail);

    AccountSns findBySnsEmailAndRefreshToken(String SnsEmail, String refreshToken);
}
