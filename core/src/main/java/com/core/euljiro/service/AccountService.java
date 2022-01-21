package com.core.euljiro.service;

import com.core.euljiro.domain.Account;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Integer save(AccountDTO vO) {
        Account bean = new Account();
        BeanUtils.copyProperties(vO, bean);
        bean = accountRepository.save(bean);
        return bean.getAccountId();
    }

    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }

    public void update(Integer id, AccountDTO vO) {
        Account bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accountRepository.save(bean);
    }

    public AccountDTO getById(Integer id) {
        Account original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccountDTO> query(AccountDTO vO) {
        throw new UnsupportedOperationException();
    }

    private AccountDTO toDTO(Account original) {
        AccountDTO bean = new AccountDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Account requireOne(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
