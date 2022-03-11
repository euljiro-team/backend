package com.core.euljiro.repository;

import com.core.euljiro.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> , JpaSpecificationExecutor<Course>{

//    @Query( value = "SELECT * from COURSE p where " +
//            "DATE_FORMAT ( :baseDt , '%Y%m%d' ) " +
//            "between date_format(p.crs_strt_dt,'%Y%m%d')  and date_format(p.crs_end_dt,'%Y%m%d') " +
//            "and p.cntr_id = :cntrId"
//    )
//    public List<Course> getCourseListOfTheday(@Param("baseDt") String baseDt , @Param("cntrId") int cntrId);

    //public List<Course> findByCrsStrtDtAfterAndCrsEndDtBeforeAndCntrId(LocalDate startDate, LocalDate endDate, Integer cntrId);
    public List<Course> findByCrsStrtDtGreaterThanEqualAndCrsEndDtLessThanEqualAndCntrId(LocalDate StrtDt, LocalDate endDate, Integer cntrId);
}
