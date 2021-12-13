package com.example.lesson;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.ws.RespectBinding;

@Configuration
public class H2DB {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public static DataSource getDatasource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser("test");
        dataSource.setPassword("test");
        dataSource.setURL("jdbc:h2:tcp://localhost/~/test");
        return dataSource;
    }
}
