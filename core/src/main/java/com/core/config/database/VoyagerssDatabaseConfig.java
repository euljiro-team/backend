package com.core.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "euljiroEntityManagerFactory",
    transactionManagerRef = "euljiroTransactionManager",
    basePackages = {"com.core.euljiro.*.repository"}
)
@MapperScan(basePackages = "com.core.euljiro", annotationClass = org.apache.ibatis.annotations.Mapper.class, sqlSessionFactoryRef = "euljiroSqlSessionFactory")
public class VoyagerssDatabaseConfig extends HikariConfig {

    //    private final JpaProperties jpaProperties;
//    private final HibernateProperties hibernateProperties;
    @Autowired
    Environment env;

    @Autowired
    VoyagerssDatabaseProperties euljiroDatabaseProperties;

    @Bean
    public Properties euljiroDBProperties() {
        Properties euljiroProperties = new Properties();
        euljiroProperties.put("jdbcUrl", this.euljiroDatabaseProperties.getUrl());
        euljiroProperties.put("username", this.euljiroDatabaseProperties.getUsername());
        euljiroProperties.put("password", this.euljiroDatabaseProperties.getPassword());
        euljiroProperties.put("driverClassName", this.euljiroDatabaseProperties.getDriverClassName());
        return euljiroProperties;
    }

    @Bean
    @BatchDataSource
    public DataSource euljiroDataSource() {
        HikariConfig config = new HikariConfig(euljiroDBProperties());
        return new LazyConnectionDataSourceProxy(new HikariDataSource(config));
//        DataSource dataSource = DataSourceBuilder.create().build();
//        return DataSourceBuilder.create().build();
    }


    @Bean(name = "euljiroEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean euljiroEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();

        return builder.dataSource(euljiroDataSource())
            .properties(properties)
            .packages(new String[]{"com.core.euljiro.*.domain"})
            .persistenceUnit("euljiroEntityManager")
            .build();
    }

    @Bean

    public PlatformTransactionManager euljiroTransactionManager(
        EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(
            Objects.requireNonNull(euljiroEntityManagerFactory(builder).getObject()));
    }


    //    mybatis config ----------------------------------------------------
    @Bean(name = "euljiroSqlSessionFactory")
    public SqlSessionFactory euljiroSqlSessionFactory(
        ApplicationContext applicationContext
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(euljiroDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.core.euljiro.*.domain");
//        sqlSessionFactoryBean.setConfigLocation(
//                applicationContext.getResource("classpath:/mybatis/homs/mybatis-config.xml")
//        );
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath*:/mybatis/euljiro/**/**.xml")
        );
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "euljiroSessionTemplate")
    public SqlSessionTemplate euljiroSqlSessionTemplate(
        @Qualifier("euljiroSqlSessionFactory") SqlSessionFactory euljiroSqlSessionFactory) {
        return new SqlSessionTemplate(euljiroSqlSessionFactory);
    }
}
