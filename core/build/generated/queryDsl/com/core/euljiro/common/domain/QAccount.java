package com.core.euljiro.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 344854734L;

    public static final QAccount account = new QAccount("account");

    public final StringPath accessToken = createString("accessToken");

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    public final ListPath<AccountRole, QAccountRole> accountRoles = this.<AccountRole, QAccountRole>createList("accountRoles", AccountRole.class, QAccountRole.class, PathInits.DIRECT2);

    public final ListPath<AccountSns, QAccountSns> accountSnsList = this.<AccountSns, QAccountSns>createList("accountSnsList", AccountSns.class, QAccountSns.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath emailVerifiedYn = createString("emailVerifiedYn");

    public final StringPath englishName = createString("englishName");

    public final StringPath koreanName = createString("koreanName");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final EnumPath<com.core.euljiro.EnumMaster.ProviderType> providerType = createEnum("providerType", com.core.euljiro.EnumMaster.ProviderType.class);

    public final StringPath refreshToken = createString("refreshToken");

    public final EnumPath<com.core.euljiro.EnumMaster.RoleType> role = createEnum("role", com.core.euljiro.EnumMaster.RoleType.class);

    public final EnumPath<com.core.euljiro.EnumMaster.Status> status = createEnum("status", com.core.euljiro.EnumMaster.Status.class);

    public final StringPath userId = createString("userId");

    public final StringPath username = createString("username");

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

