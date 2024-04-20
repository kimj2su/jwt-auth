package com.jisu.auth;

import com.jisu.auth.JwtTokenProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class JwtTokenPropertiesTest {

    @Autowired
    private JwtTokenProperties jwtTokenProperties;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Test
    void getSecretKey() {
        // given

        // when
        String secretKey = jwtTokenProperties.getSecretKey();

        // then
        assertThat(secretKey).isNotNull();
        assertThat(secretKey).isEqualTo(this.secretKey);
    }

    @Test
    void getTokenExpiredTimeMs() {
        // given

        // when
        Long tokenExpiredTimeMs = jwtTokenProperties.getTokenExpiredTimeMs();

        // then
        assertThat(tokenExpiredTimeMs).isNotNull();
    }
}