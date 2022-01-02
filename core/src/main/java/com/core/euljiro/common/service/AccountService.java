package com.core.euljiro.common.service;

import com.core.euljiro.EnumMaster;
import com.core.euljiro.common.domain.Account;
import com.core.euljiro.common.domain.AccountSns;
import com.core.euljiro.common.dto.AccountDto;
import com.core.euljiro.common.querydsl.AccountRepositorySupport;
import com.core.euljiro.common.repository.AccountRepository;
import com.core.euljiro.common.repository.AccountRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
public class AccountService
//        implements UserDetailsService
{
    @Autowired    private AccountRepository accountRepository;
    @Autowired    private AccountRoleRepository accountRoleRepository;
    @Autowired    private AccountRepositorySupport accountRepositorySupport;


//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Account account = accountRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
//        return new AccountAdapter(account);
//    }
    public AccountDto getUser(String userId) {
        Account sourse = accountRepository.findByUserId(userId);
        return toDTO(sourse);
    }

    @Transactional
    public Account signin(AccountDto vO) {
        Account account = new Account(vO);
        return accountRepository.save(account);
    }

    public Account save(AccountDto vO) {
        Account account = accountRepository.findByEnglishName(vO.getEnglishName())
                .orElse(new Account(vO));
        BeanUtils.copyProperties(vO, account);
        account = accountRepository.save(account);
        return account;
    }

    public void update(Integer id, AccountDto vO) {
        Account bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        accountRepository.save(bean);
    }

    public AccountDto getById(Integer id) {
        Account original = requireOne(id);
        return toDTO(original);
    }


    private AccountDto toDTO(Account original) {
        AccountDto bean = new AccountDto(original);
        return bean;
    }

    private Account requireOne(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public Page<AccountDto> findByUsernameContains(String accountName, Pageable pageable) {
        return accountRepository.findByUsernameContains(accountName, pageable)
                .map(account -> toDTO(account));
    }

    public Page<AccountDto> getAccountWithRolesAndNameLike(EnumMaster.RoleType roleType, String accountName, Pageable pageable) {
        return accountRepositorySupport.getAccountWithRolesAndNameLike(roleType, accountName, pageable);
    }

}
