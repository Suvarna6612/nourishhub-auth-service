package com.nourishhub.auth_service.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET =
            "myverysecuresecretkeymyverysecuresecretkey123456";

    private final Key key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // GENERATE JWT TOKEN
    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // EXTRACT ALL CLAIMS
    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // EXTRACT USERNAME
    public String extractUsername(String token) {

        return extractClaims(token)
                .getSubject();
    }

    // VALIDATE TOKEN
    public boolean validateToken(
            String token,
            String username
    ) {

        String extractedUsername =
                extractUsername(token);

        return extractedUsername.equals(username);
    }

    public String extractRole(String token) {
        return extractClaims(token)
                .get("role", String.class);
    }
}