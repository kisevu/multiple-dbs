package com.ameda.oracle.config;/*
*
@author ameda
@project mDS
*
*/

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
basePackages = "com.ameda.oracle.products.repository",
entityManagerFactoryRef = "mysqlEntityManagerFactoryBean",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlEntityManagerConfig {


   @Bean
    LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("mysqlDatasource") DataSource dataSource
            ){
    return entityManagerFactoryBuilder
            .dataSource(dataSource)
            .packages("com.ameda.oracle.products.entity")
            .build();
    }

    @Bean
    PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb){
    return  new JpaTransactionManager(emfb.getObject());
    }
}
