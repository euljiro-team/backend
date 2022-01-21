package com.core.euljiro.service;

import com.core.euljiro.domain.AccountRole;
import com.core.euljiro.dto.AccountRoleDTO;
import com.core.euljiro.repository.AccountRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountRoleService {

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    public Integer save(AccountRoleDTO vO) {
        AccountRole bean = new AccountRole();
        BeanUtils.copyProperties(vO, bean);
        bean = accountRoleRepository.save(bean);
        return bean.getAccountRoleId();
    }

    public void delete(Integer id) {
        accountRoleRepository.deleteById(id);
    }

    public void update(Integer id, AccountRoleDTO vO) {
        AccountRole bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accountRoleRepository.save(bean);
    }

    public AccountRoleDTO getById(Integer id) {
        AccountRole original = requireOne(id);
        return toDTO(original);
    }

    public Page<AccountRoleDTO> query(AccountRoleDTO vO) {
        throw new UnsupportedOperationException();
    }

    private AccountRoleDTO toDTO(AccountRole original) {
        AccountRoleDTO bean = new AccountRoleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AccountRole requireOne(Integer id) {
        return accountRoleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
