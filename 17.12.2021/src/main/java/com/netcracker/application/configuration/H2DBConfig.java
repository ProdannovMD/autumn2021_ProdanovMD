package com.netcracker.application.configuration;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2DBConfig {
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public DataSource dataSource() {
        JdbcDataSource h2DataSource = new JdbcDataSource();
        h2DataSource.setURL("jdbc:h2:tcp://localhost/~/test");
        h2DataSource.setUser("test");
        h2DataSource.setPassword("test");
        return h2DataSource;
    }
}
