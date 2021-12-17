package com.netcracker.application.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${auth.password.hash.algorithm}")
    private String algorithm;

    @Bean
//    @Scope("prototype")
    public MessageDigest messageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }
}
