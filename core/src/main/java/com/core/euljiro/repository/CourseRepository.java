package com.core.euljiro.repository;

import com.core.euljiro.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course,Long> , JpaSpecificationExecutor<Course>{
}
