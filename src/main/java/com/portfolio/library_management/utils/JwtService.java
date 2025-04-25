package com.portfolio.library_management.utils;

import com.portfolio.library_management.dto.AuthDTO.AuthReqDTO;
import com.portfolio.library_management.dto.AuthDTO.AuthResDTO;
import com.portfolio.library_management.model.Member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {

    private final String secret = "VGhpcyBpcyBhIHZlcnkgc2VjdXJlIHNlY3JldCBrZXkzMg=="; // base64-encoded
    private final Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
    private final long expiration = 1000 * 60 * 60 * 24; // 24 hours

    public String generateToken(AuthResDTO dto) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, dto.getId());
    }

    private String createToken(Map<String, Object> claims, UUID subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject.toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS256) // ✅ use `secretKey`
                .compact();
    }

    public String extractUserId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(secretKey) // ✅ use `secretKey`
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean validateToken(String token, Member member) {
        final String userId = extractUserId(token);
        return (userId.equals(member.getId().toString()) && !isTokenExpired(token));
    }
}
