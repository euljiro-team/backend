package com.core.euljiro.service;

import com.core.euljiro.domain.MetaTable;
import com.core.euljiro.dto.MetaTableDTO;
import com.core.euljiro.repository.MetaTableRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MetaTableService {

    @Autowired
    private MetaTableRepository metaTableRepository;

    public String save(MetaTableDTO vO) {
        MetaTable bean = new MetaTable();
        BeanUtils.copyProperties(vO, bean);
        bean = metaTableRepository.save(bean);
        return bean.getWORD();
    }

    public void delete(String id) {
        metaTableRepository.deleteById(id);
    }

    public void update(String id, MetaTableDTO vO) {
        MetaTable bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        metaTableRepository.save(bean);
    }

    public MetaTableDTO getById(String id) {
        MetaTable original = requireOne(id);
        return toDTO(original);
    }

    public Page<MetaTableDTO> query(MetaTableDTO vO) {
        throw new UnsupportedOperationException();
    }

    private MetaTableDTO toDTO(MetaTable original) {
        MetaTableDTO bean = new MetaTableDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MetaTable requireOne(String id) {
        return metaTableRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
