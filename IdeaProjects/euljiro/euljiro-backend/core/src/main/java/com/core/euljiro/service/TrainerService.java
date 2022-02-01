package com.core.euljiro.service;

import com.core.euljiro.domain.Trainer;
import com.core.euljiro.dto.TrainerDTO;
import com.core.euljiro.repository.TrainerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Integer save(TrainerDTO vO) {
        Trainer bean = new Trainer();
        BeanUtils.copyProperties(vO, bean);
        bean = trainerRepository.save(bean);
        return bean.getTrainerId();
    }

    public void delete(Integer id) {
        trainerRepository.deleteById(id);
    }

    public void update(Integer id, TrainerDTO vO) {
        Trainer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        trainerRepository.save(bean);
    }

    public TrainerDTO getById(Integer id) {
        Trainer original = requireOne(id);
        return toDTO(original);
    }

    public Page<TrainerDTO> query(TrainerDTO vO) {
        throw new UnsupportedOperationException();
    }

    private TrainerDTO toDTO(Trainer original) {
        TrainerDTO bean = new TrainerDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Trainer requireOne(Integer id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
