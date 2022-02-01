package com.core.euljiro.repository;

import com.core.euljiro.domain.CourseMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseMembershipRepository extends JpaRepository<CourseMembership, Integer>, JpaSpecificationExecutor<CourseMembership> {

}
