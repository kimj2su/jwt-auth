package com.jisu.auth;

public interface JwtTokenProperties {

    String getSecretKey();

    Long getTokenExpiredTimeMs();
}
