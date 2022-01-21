package com.core.euljiro.repository;

import com.core.euljiro.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {

}
