package com.core.euljiro.service;

import com.core.euljiro.domain.Account;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.querydsl.AccountRepositorySupport;
import com.core.euljiro.repository.AccountRepository;
import com.core.euljiro.repository.AccountRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private AccountRepositorySupport accountRepositorySupport;


    //    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Account account = accountRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
//        return new AccountAdapter(account);
//    }
    public AccountDTO getUser(String userId) {
        Account sourse = accountRepository.findByUserId(userId);
        return toDTO(sourse);
    }

    @Transactional
    public Account signin(AccountDTO vO) {
        Account account = new Account(vO);
        return accountRepository.save(account);
    }

    public Account save(AccountDTO vO) {
        Account account = accountRepository.findByEnglishName(vO.getEnglishName())
                .orElse(new Account(vO));
        BeanUtils.copyProperties(vO, account);
        account = accountRepository.save(account);
        return account;
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


    private AccountDTO toDTO(Account original) {
        AccountDTO bean = new AccountDTO(original);
        return bean;
    }

    private Account requireOne(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public Page<AccountDTO> findByUsernameContains(String accountName, Pageable pageable) {
        return accountRepository.findByUsernameContains(accountName, pageable)
                .map(account -> toDTO(account));
    }

//        public Page<AccountDTO> getAccountWithRolesAndNameLike(EnumMaster.RoleType roleType, String accountName, Pageable pageable) {
//            return accountRepositorySupport.getAccountWithRolesAndNameLike(roleType, accountName, pageable);
//        }

}
