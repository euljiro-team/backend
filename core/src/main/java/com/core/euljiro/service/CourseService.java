package com.core.euljiro.service;


import com.core.euljiro.domain.Course;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.dto.DevUsersDTO;
import com.core.euljiro.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(CourseDTO vo) {
        Course bean = new Course();
        BeanUtils.copyProperties(vo,bean);
        bean = courseRepository.save(bean);
        return bean;
    }

    public CourseDTO getById(Long crsId){
        CourseDTO vo = new CourseDTO();
        Course bean = courseRepository.findById(crsId).orElseThrow(()-> new NoSuchElementException("no such Element : " + crsId));
        BeanUtils.copyProperties(bean,vo);
        return vo;
    }

    public void deleteById(Long crsId){
        courseRepository.deleteById(crsId);
    }

    public void update(Long crsId, CourseDTO vo){
        Course bean = courseRepository.getOne(crsId);
        BeanUtils.copyProperties(vo,bean);
        courseRepository.save(bean);
    }

    public Page<CourseDTO> query(CourseDTO vO) {
        throw new UnsupportedOperationException();
    }
}
