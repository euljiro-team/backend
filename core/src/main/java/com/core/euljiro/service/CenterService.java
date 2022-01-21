package com.core.euljiro.service;

import com.core.euljiro.domain.Center;
import com.core.euljiro.dto.CenterDTO;
import com.core.euljiro.repository.CenterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public Integer save(CenterDTO vO) {
        Center bean = new Center();
        BeanUtils.copyProperties(vO, bean);
        bean = centerRepository.save(bean);
        return bean.getCenterId();
    }

    public void delete(Integer id) {
        centerRepository.deleteById(id);
    }

    public void update(Integer id, CenterDTO vO) {
        Center bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        centerRepository.save(bean);
    }

    public CenterDTO getById(Integer id) {
        Center original = requireOne(id);
        return toDTO(original);
    }

    public Page<CenterDTO> query(CenterDTO vO) {
        throw new UnsupportedOperationException();
    }

    private CenterDTO toDTO(Center original) {
        CenterDTO bean = new CenterDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Center requireOne(Integer id) {
        return centerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
