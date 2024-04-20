package com.jisu.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class JwtConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JwtTokenProperties jwtTokenProperties() {
        System.out.println("original");
        return new DefaultJwtTokenProperties();
    }
}
