package com.core.euljiro.repository;

import com.core.euljiro.domain.MetaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MetaTableRepository extends JpaRepository<MetaTable, String>, JpaSpecificationExecutor<MetaTable> {

}
