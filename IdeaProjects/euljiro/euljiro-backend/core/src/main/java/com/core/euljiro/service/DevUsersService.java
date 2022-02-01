package com.core.euljiro.service;

import com.core.euljiro.domain.DevUsers;
import com.core.euljiro.dto.DevUsersDTO;
import com.core.euljiro.repository.DevUsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DevUsersService {

    @Autowired
    private DevUsersRepository devUsersRepository;

    public Integer save(DevUsersDTO vO) {
        DevUsers bean = new DevUsers();
        BeanUtils.copyProperties(vO, bean);
        bean = devUsersRepository.save(bean);
        return bean.getID();
    }

    public void delete(Integer id) {
        devUsersRepository.deleteById(id);
    }

    public void update(Integer id, DevUsersDTO vO) {
        DevUsers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        devUsersRepository.save(bean);
    }

    public DevUsersDTO getById(Integer id) {
        DevUsers original = requireOne(id);
        return toDTO(original);
    }

    public Page<DevUsersDTO> query(DevUsersDTO vO) {
        throw new UnsupportedOperationException();
    }

    private DevUsersDTO toDTO(DevUsers original) {
        DevUsersDTO bean = new DevUsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DevUsers requireOne(Integer id) {
        return devUsersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
