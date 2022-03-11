package com.core.euljiro.service;

import com.core.euljiro.domain.CourseMembership;
import com.core.euljiro.dto.CourseMembershipDTO;
import com.core.euljiro.repository.CourseMembershipRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseMembershipService {

    @Autowired
    private CourseMembershipRepository courseMembershipRepository;

    public Long save(CourseMembershipDTO vO) {
        CourseMembership bean = new CourseMembership();
        BeanUtils.copyProperties(vO, bean);
        bean = courseMembershipRepository.save(bean);
        return bean.getCrsId();
    }

    public void delete(Integer id) {
        courseMembershipRepository.deleteById(id);
    }

    public void update(Integer id, CourseMembershipDTO vO) {
        CourseMembership bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        courseMembershipRepository.save(bean);
    }

    public CourseMembershipDTO getById(Integer id) {
        CourseMembership original = requireOne(id);
        return toDTO(original);
    }

    public Page<CourseMembershipDTO> query(CourseMembershipDTO vO) {
        throw new UnsupportedOperationException();
    }

    private CourseMembershipDTO toDTO(CourseMembership original) {
        CourseMembershipDTO bean = new CourseMembershipDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CourseMembership requireOne(Integer id) {
        return courseMembershipRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
