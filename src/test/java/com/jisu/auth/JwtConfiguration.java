package com.jisu.auth;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class JwtConfiguration {

    @Bean
    public JwtTokenProperties jwtTokenProperties() {
        System.out.println("original222");
        return new JwtTokenPropertiesImpl();
    }
}
