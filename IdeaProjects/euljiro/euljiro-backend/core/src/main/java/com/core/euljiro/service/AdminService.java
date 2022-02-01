package com.core.euljiro.service;

import com.core.euljiro.domain.Admin;
import com.core.euljiro.dto.AdminDTO;
import com.core.euljiro.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Integer save(AdminDTO vO) {
        Admin bean = new Admin();
        BeanUtils.copyProperties(vO, bean);
        bean = adminRepository.save(bean);
        return bean.getAdminId();
    }

    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }

    public void update(Integer id, AdminDTO vO) {
        Admin bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        adminRepository.save(bean);
    }

    public AdminDTO getById(Integer id) {
        Admin original = requireOne(id);
        return toDTO(original);
    }

    public Page<AdminDTO> query(AdminDTO vO) {
        throw new UnsupportedOperationException();
    }

    private AdminDTO toDTO(Admin original) {
        AdminDTO bean = new AdminDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Admin requireOne(Integer id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
