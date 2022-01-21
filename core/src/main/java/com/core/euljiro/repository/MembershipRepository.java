package com.core.euljiro.repository;

import com.core.euljiro.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MembershipRepository extends JpaRepository<Membership, Integer>, JpaSpecificationExecutor<Membership> {

}
