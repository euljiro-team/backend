package com.core.euljiro.repository;

import com.core.euljiro.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrainerRepository extends JpaRepository<Trainer, Integer>, JpaSpecificationExecutor<Trainer> {

}
