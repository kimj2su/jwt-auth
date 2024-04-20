package com.jisu.auth;

import com.jisu.auth.JwtTokenProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JwtTokenPropertiesImpl implements JwtTokenProperties {

    private String secretKey;

    private Long tokenExpiredTimeMs;

    @Override
    public String getSecretKey() {
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
