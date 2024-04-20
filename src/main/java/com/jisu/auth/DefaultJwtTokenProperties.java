package com.jisu.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class DefaultJwtTokenProperties implements JwtTokenProperties {

    private String secretKey;

    private Long tokenExpiredTimeMs;

    @Override
    public String getSecretKey() {
        System.out.println("original");
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public Long getTokenExpiredTimeMs() {
        return tokenExpiredTimeMs;
    }

    public void setTokenExpiredTimeMs(Long tokenExpiredTimeMs) {
        this.tokenExpiredTimeMs = tokenExpiredTimeMs;
    }
}
