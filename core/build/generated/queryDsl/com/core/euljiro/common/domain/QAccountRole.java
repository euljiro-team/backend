package com.core.euljiro.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountRole is a Querydsl query type for AccountRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountRole extends EntityPathBase<AccountRole> {

    private static final long serialVersionUID = 176418404L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountRole accountRole = new QAccountRole("accountRole");

    public final QAccount account;

    public final NumberPath<Integer> accountRoleId = createNumber("accountRoleId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final EnumPath<com.core.euljiro.EnumMaster.RoleType> roleType = createEnum("roleType", com.core.euljiro.EnumMaster.RoleType.class);

    public QAccountRole(String variable) {
        this(AccountRole.class, forVariable(variable), INITS);
    }

    public QAccountRole(Path<? extends AccountRole> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountRole(PathMetadata metadata, PathInits inits) {
        this(AccountRole.class, metadata, inits);
    }

    public QAccountRole(Class<? extends AccountRole> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
    }

}

