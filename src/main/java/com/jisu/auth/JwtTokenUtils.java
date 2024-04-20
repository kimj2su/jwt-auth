package com.jisu.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtils {

    public static Object getClaim(String token, String key, String claimName, Class<?> type) {
        return extractClaims(token, key).get(claimName, type);
    }

    public static String getClaim(String token, String key, String claimName) {
        return extractClaims(token, key).get(claimName, String.class);
    }

    public static boolean isExpired(String token, String key) {
        Date expiredDate = extractClaims(token, key).getExpiration();
        return expiredDate.before(new Date());
    }

    private static Claims extractClaims(String token, String key) {
        return Jwts.parser().verifyWith(getKey(key))
                .build().parseSignedClaims(token).getPayload();
    }

    public static String generateToken(Map<String, Object> payload,  String key, long expiredTimeMS) {
        ClaimsBuilder claimsBuilder = Jwts.claims();
        payload.forEach(claimsBuilder::add);
        Claims claims = claimsBuilder.build();

        return Jwts.builder().claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredTimeMS))
                .signWith(getKey(key), Jwts.SIG.HS256)
                .compact();
    }

    private static SecretKey getKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}