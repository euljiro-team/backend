package com.core.euljiro.service;

import com.core.euljiro.domain.Course;
import com.core.euljiro.domain.CourseReservation;
import com.core.euljiro.domain.Membership;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.dto.CourseReservationDto;
import com.core.euljiro.repository.CenterRepository;
import com.core.euljiro.repository.CourseRepository;
import com.core.euljiro.repository.CourseReservationRepository;
import com.core.euljiro.repository.MembershipRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseReservationService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseReservationRepository courseReservationRepository;

    @Transactional
    public List<CourseDTO> getCourseList (int mmbrshpId, int userId, int cntrId, String baseDt){
        //int cntrId = membershipService.getById(mmbrshpId).getCenterId(); // centerId를 가져온다
        LocalDate baseLocalTime = LocalDate.parse(baseDt, DateTimeFormatter.ofPattern("yyyyMMdd"));
        //.withLocale(Locale.KOREA));
        return courseRepository.findByCrsStrtDtGreaterThanEqualAndCrsEndDtLessThanEqualAndCntrId(baseLocalTime,baseLocalTime.plusDays(1),cntrId).stream()
                .map(course -> new CourseDTO(course)).collect(Collectors.toList()); // 기준일자의 수업 리스트 조회
    }

    @Transactional
    public CourseReservation saveCrsSrv(CourseReservationDto vo){
        CourseReservation bean = new CourseReservation();
        BeanUtils.copyProperties(vo,bean);
        bean = courseReservationRepository.save(bean);

        Course crs = courseRepository.getOne(vo.getCrsId());
        if(crs==null) throw new NoSuchElementException("no such element : " + vo.getCrsId());
        else {
            crs.setRegNum(crs.getRegNum() + 1);
            courseRepository.save(crs);
        }
        return bean;
    }

    @Transactional
    public void delReservation(CourseReservationDto vo){
        courseReservationRepository.deleteById(vo.getAccountId());
        Course crs = courseRepository.getOne(vo.getCrsId());
        if(crs==null) throw new NoSuchElementException("no such element : " + vo.getCrsId());
        else {
            crs.setRegNum(crs.getRegNum() - 1);
            courseRepository.save(crs);
        }
    }


}
