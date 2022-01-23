package com.core.euljiro.querydsl;


import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import com.core.euljiro.dto.AccountDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountRepositorySupport extends QuerydslRepositorySupport {
    private EntityManager em;
    private JPAQueryFactory queryFactory;

    public AccountRepositorySupport(JPAQueryFactory mariaJpaQueryFactory) {
        super(Account.class);
        this.queryFactory = mariaJpaQueryFactory;
    }

    @Override
    @PersistenceContext(unitName = "euljiroEntityManager")
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        em = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

//    QAccount account = QAccount.account;
//    QAccountRole accountRole = QAccountRole.accountRole;
//    QAccountSns accountSns = QAccountSns.accountSns;
//
//    // teacher
//    public Page<AccountDTO> getAccountWithRolesAndNameLike(EnumMaster.RoleType roleType, String accountName, Pageable pageable) {
//        JPAQuery query = queryFactory.select(Projections.fields(AccountDTO.class,
//                account.accountId,
//                account.username,
//                account.password,
//                account.email,
//                account.koreanName,
//                account.englishName,
//                account.phone
//        ))
//                .from(account)
//                .leftJoin(accountRole).on(accountRole.account.eq(account))
//                .where(
//                    likeAccountName(accountName),
//                    accountRole.roleType.eq(roleType)
//                )
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize());;
//
//        List<AccountDTO> accounts = query.fetch();
//        accounts.stream()
//                .forEach(account1 -> {
//                    List<EnumMaster.RoleType> accountRoles = queryFactory.selectFrom(accountRole)
//                        .where(accountRole.account.accountId.eq(account1.getAccountId())).fetch()
//                            .stream()
//                            .map(role1 -> role1.getRoleType())
//                            .collect(Collectors.toList());
//
//                    account1.setAccountRoles(accountRoles);
//                });
//        return new PageImpl(accounts, pageable, query.fetchCount());
//    }
//
//    private BooleanExpression likeAccountName(String accountName) {
//        if (accountName == null) return null;
//        return account.username.like("%" + accountName + "%");
//    }
//
//
//
//    private BooleanExpression eqStatus(Integer teacherId) {
//        if (teacherId == null) return null;
//        return account.accountId.eq(teacherId);
//    }

}
