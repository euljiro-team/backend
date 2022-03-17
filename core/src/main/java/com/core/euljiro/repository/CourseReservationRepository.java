package com.core.euljiro.repository;

import com.core.euljiro.domain.CourseReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReservationRepository extends JpaRepository<CourseReservation, Integer > {

}
