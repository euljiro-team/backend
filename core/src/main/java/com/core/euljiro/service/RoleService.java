package com.core.euljiro.service;

import com.core.euljiro.domain.Role;
import com.core.euljiro.dto.RoleDTO;
import com.core.euljiro.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Integer save(RoleDTO vO) {
        Role bean = new Role();
        BeanUtils.copyProperties(vO, bean);
        bean = roleRepository.save(bean);
        return bean.getID();
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void update(Integer id, RoleDTO vO) {
        Role bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        roleRepository.save(bean);
    }

    public RoleDTO getById(Integer id) {
        Role original = requireOne(id);
        return toDTO(original);
    }

    public Page<RoleDTO> query(RoleDTO vO) {
        throw new UnsupportedOperationException();
    }

    private RoleDTO toDTO(Role original) {
        RoleDTO bean = new RoleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Role requireOne(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
