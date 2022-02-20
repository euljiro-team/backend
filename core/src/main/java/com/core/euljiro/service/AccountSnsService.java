package com.core.euljiro.service;

import com.core.euljiro.domain.AccountSns;
import com.core.euljiro.dto.AccountSnsDTO;
import com.core.euljiro.repository.AccountSnsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountSnsService {

    @Autowired
    private AccountSnsRepository accountSnsRepository;

//    public Long save(AccountSnsDTO vO) {
//        AccountSns bean = new AccountSns();
//        BeanUtils.copyProperties(vO, bean);
//        bean = accountSnsRepository.save(bean);
//        return bean.getAccountSnsId();
//    }
//
//    public void delete(Long id) {
//        accountSnsRepository.deleteById(id);
//    }
//
//    public void update(Long id, AccountSnsDTO vO) {
//        AccountSns bean = requireOne(id);
//        BeanUtils.copyProperties(vO, bean);
//        accountSnsRepository.save(bean);
//    }
//
//    public AccountSnsDTO getById(Long id) {
//        AccountSns original = requireOne(id);
//        return toDTO(original);
//    }
//
//    public Page<AccountSnsDTO> query(AccountSnsDTO vO) {
//        throw new UnsupportedOperationException();
//    }
//
//    private AccountSnsDTO toDTO(AccountSns original) {
//        AccountSnsDTO bean = new AccountSnsDTO();
//        BeanUtils.copyProperties(original, bean);
//        return bean;
//    }
//
//    private AccountSns requireOne(Long id) {
//        return accountSnsRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
//    }
}
