package com.core.euljiro.service;

import com.core.euljiro.domain.Notice;
import com.core.euljiro.dto.NoticeDTO;
import com.core.euljiro.repository.NoticeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Integer save(NoticeDTO vO) {
        Notice bean = new Notice();
        BeanUtils.copyProperties(vO, bean);
        bean = noticeRepository.save(bean);
        return bean.getNoticeId();
    }

    public void delete(Integer id) {
        noticeRepository.deleteById(id);
    }

    public void update(Integer id, NoticeDTO vO) {
        Notice bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        noticeRepository.save(bean);
    }

    public NoticeDTO getById(Integer id) {
        Notice original = requireOne(id);
        return toDTO(original);
    }

    public Page<NoticeDTO> findByTitleContains(NoticeDTO vO, Pageable pageable) {
        return noticeRepository.findByTitleContains(vO.getTitle(), pageable)
                .map(notice -> toDTO(notice));
    }

    public List<NoticeDTO> findAll() {
        return (List<NoticeDTO>) noticeRepository.findAll().stream().map(this::toDTO);
    }

    private NoticeDTO toDTO(Notice original) {
        NoticeDTO bean = new NoticeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Notice requireOne(Integer id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
