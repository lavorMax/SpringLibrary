package com.ttl.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCTemplateConfig {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();

        driverManager.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        driverManager.setUrl("jdbc:sqlserver://localhost:1433;"
                + "databaseName=SpringJavaLibrary;"
                + "user=java;"
                + "password=123456;"
                + "encrypt=true;"
                + "trustServerCertificate=true");

        return driverManager;
    }
}
