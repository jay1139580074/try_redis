package com.junjie.tryredis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(DataSource.class)
//@ConditionalOnBean
public class DatasourceProperties {

    @Bean
    @ConfigurationProperties(prefix = "com.junjie.tryredis.leetCode")
    public  DataSource dataSource() {
        return null;
    }
}
