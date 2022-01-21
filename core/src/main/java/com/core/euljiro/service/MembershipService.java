package com.core.euljiro.service;

import com.core.euljiro.domain.Membership;
import com.core.euljiro.dto.MembershipDTO;
import com.core.euljiro.repository.MembershipRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    public Integer save(MembershipDTO vO) {
        Membership bean = new Membership();
        BeanUtils.copyProperties(vO, bean);
        bean = membershipRepository.save(bean);
        return bean.getMmbrshpId();
    }

    public void delete(Integer id) {
        membershipRepository.deleteById(id);
    }

    public void update(Integer id, MembershipDTO vO) {
        Membership bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        membershipRepository.save(bean);
    }

    public MembershipDTO getById(Integer id) {
        Membership original = requireOne(id);
        return toDTO(original);
    }

    public Page<MembershipDTO> query(MembershipDTO vO) {
        throw new UnsupportedOperationException();
    }

    private MembershipDTO toDTO(Membership original) {
        MembershipDTO bean = new MembershipDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Membership requireOne(Integer id) {
        return membershipRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
