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

import javax.sql.DataSource;

@Configuration
public class PostgresDatasourceProperties {

    @ConfigurationProperties("spring.datasource.pg")
    @Bean
    public DataSourceProperties postgresDataSourceProperties(){
    return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDatasource(){
    return postgresDataSourceProperties().initializeDataSourceBuilder().build() ; }
}
