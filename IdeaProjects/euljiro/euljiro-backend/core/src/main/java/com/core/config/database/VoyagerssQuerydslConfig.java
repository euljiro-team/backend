package com.core.config.database;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class VoyagerssQuerydslConfig {

    @PersistenceContext(unitName = "euljiroEntityManager")
    private EntityManager euljiroEntityManager;


    @Bean
    public JPAQueryFactory euljiroJpaQueryFactory() {
        return new JPAQueryFactory(euljiroEntityManager);
    }

}
