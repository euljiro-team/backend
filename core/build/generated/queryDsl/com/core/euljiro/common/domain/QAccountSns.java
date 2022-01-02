package com.core.euljiro.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountSns is a Querydsl query type for AccountSns
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountSns extends EntityPathBase<AccountSns> {

    private static final long serialVersionUID = 5691850L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountSns accountSns = new QAccountSns("accountSns");

    public final StringPath accessToken = createString("accessToken");

    public final QAccount account;

    public final NumberPath<Long> accountSnsId = createNumber("accountSnsId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath emailVerifiedYn = createString("emailVerifiedYn");

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final EnumPath<com.core.euljiro.EnumMaster.ProviderType> providerType = createEnum("providerType", com.core.euljiro.EnumMaster.ProviderType.class);

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath snsEmail = createString("snsEmail");

    public final StringPath userId = createString("userId");

    public QAccountSns(String variable) {
        this(AccountSns.class, forVariable(variable), INITS);
    }

    public QAccountSns(Path<? extends AccountSns> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountSns(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountSns(PathMetadata metadata, PathInits inits) {
        this(AccountSns.class, metadata, inits);
    }

    public QAccountSns(Class<? extends AccountSns> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
    }

}

