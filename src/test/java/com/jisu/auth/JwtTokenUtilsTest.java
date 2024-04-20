package com.jisu.auth;

import com.jisu.auth.JwtTokenUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JwtTokenUtils Test")
class JwtTokenUtilsTest {

    private final String email = "kimjisu3268@gmail.com";
    private final String key = "com.jisu.auth.jwtmodule.application-2024.secret_key";
    private final Long expiredTime = 10000L;
    private final Map<String, Object> payload = Map.of("email", email);

    @Test
    void generateToken() {
        // when
        String token = JwtTokenUtils.generateToken(payload, key, expiredTime);

        // then
        assertThat(token).isNotNull();
    }

    @Test
    void isExpired() {
        // given
        String token = JwtTokenUtils.generateToken(payload, key, expiredTime);

        // when
        boolean isExpired = JwtTokenUtils.isExpired(token, key);

        // then
        assertThat(isExpired).isFalse();
    }

    @Test
    void getClaim() {
        // given
        String token = JwtTokenUtils.generateToken(payload, key, expiredTime);

        // when
        String emailFromToken = (String) JwtTokenUtils.getClaim(token, key, "email", String.class);

        // then
        assertThat(emailFromToken).isEqualTo(email);
    }

    @Test
    void getClaimToString() {
        // given




        String token = JwtTokenUtils.generateToken(payload, key, expiredTime);

        // when
        String emailFromToken = JwtTokenUtils.getClaim(token, key, "email");

        // then
        assertThat(emailFromToken).isEqualTo(email);
    }

}