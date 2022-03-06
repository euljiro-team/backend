package com.api.oauth.service;

import com.api.oauth.entity.UserPrincipal;
import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.AccountRole;
import com.core.euljiro.repository.AccountRepository;
import com.core.euljiro.repository.AccountRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        List<AccountRole> accountRoleList = accountRoleRepository.findByAccount_Email(email);
        if (account == null) {
            throw new UsernameNotFoundException("Can not find username.");
        }

//        return new User(account.getEmail(), account.getPassword(), roles);
        return UserPrincipal.create(account, accountRoleList);
    }
}
