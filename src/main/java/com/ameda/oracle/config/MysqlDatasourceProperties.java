package com.ameda.oracle.config;/*
*
@author ameda
@project mDS
*
*/

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MysqlDatasourceProperties {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties mysqlDataSourceProperties(){
    return new DataSourceProperties();
    }

//    @Bean
//    public DataSource mysqlDatasource(){
////        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////        driverManagerDataSource.setUsername(mysqlDataSourceProperties().getUsername());
////        driverManagerDataSource.setPassword(mysqlDataSourceProperties().getPassword());
////        driverManagerDataSource.setUrl(mysqlDataSourceProperties().getUrl());
////        driverManagerDataSource.setDriverClassName(mysqlDataSourceProperties().getDriverClassName());
////    return  driverManagerDataSource;
//    }

    @Primary
    @Bean
    public DataSource mysqlDatasource(){
    return mysqlDataSourceProperties().initializeDataSourceBuilder().build() ; }
    //either of the two works but the used implementation comes in handy
}
