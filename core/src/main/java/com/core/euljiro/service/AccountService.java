package com.core.euljiro.service;

import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.AccountRole;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.querydsl.AccountRepositorySupport;
import com.core.euljiro.repository.AccountRepository;
import com.core.euljiro.repository.AccountRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private AccountRepositorySupport accountRepositorySupport;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AccountDTO getUser(String userId) {
        Account sourse = accountRepository.findByUserId(userId);
        return toDTO(sourse);
    }

    @Transactional
    public Account signUp(AccountDTO accountDTO) { // 회원가입
        Account account = Account.createAccount(accountDTO, passwordEncoder);
        validateDuplicateEmail(account);

        List<AccountRole> accountRoleList = new ArrayList<>();
        accountDTO.getAccountRoles().stream().forEach(role -> {
            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(account);
            accountRole.setRoleType(role);
            accountRoleList.add(accountRole);
        });

        account.setAccountRoles(accountRoleList);

        return accountRepository.save(account);
    }

    public void validateDuplicateEmail(Account account) { // 중복된 이메일인지 확인
        Account findAccount = accountRepository.findByEmail(account.getEmail());
        if(findAccount != null) {
            throw new IllegalStateException("이미 가입된 메일주소입니다.");
        }
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
