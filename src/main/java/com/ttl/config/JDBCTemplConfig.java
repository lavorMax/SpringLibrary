package com.ttl.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCTemplConfig {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource drivarManager = new DriverManagerDataSource();
        
        drivarManager.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        drivarManager.setUrl("jdbc:sqlserver://localhost\\SQLEXPRESS;"
                        + "databaseName=SpringJavaLibrary;"
                        + "integratedSecurity=true;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true");
                
        return drivarManager;
        
        /*
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
        */
    }
    
    
    /*
    @Bean
    public JdbcTemplate createMssqlServerJDBCTemplate(){
        DriverManagerDataSource drivarManager = new DriverManagerDataSource();
        
        drivarManager.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        drivarManager.setUrl("jdbc:sqlserver://localhost\\SQLEXPRESS;"
                        + "databaseName=SpringJavaLibrary;"
                        + "integratedSecurity=true;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true");
                
        return new JdbcTemplate(drivarManager);
    }
    */
}
