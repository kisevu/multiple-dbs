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
basePackages = "com.ameda.oracle.orders.repository",
entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresEntityManagerConfig {

   @Bean
    LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("postgresDatasource") DataSource dataSource
            ){
    return entityManagerFactoryBuilder
            .dataSource(dataSource)
            .packages("com.ameda.oracle.orders.entity")
            .build();
    }

    @Bean
    PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb){
        return  new JpaTransactionManager(emfb.getObject());
    }
}
