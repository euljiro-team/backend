package com.core.euljiro.repository;

import com.core.euljiro.domain.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CenterRepository extends JpaRepository<Center, Integer>, JpaSpecificationExecutor<Center> {

}
