package com.javatechie.util;

import com.javatechie.filter.AuthenticationFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {
    private static final Logger LOGGER = LogManager.getLogger(JwtUtil.class);
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

        public void validateToken(final String token) {
            LOGGER.info("validation Token ??method is called.");
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
        }

        private Key getSignKey() {
            byte[] keyBytes = Decoders.BASE64.decode(SECRET);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        public String getClaimFromToken(String token, String claimKey) {
            final Claims claims = getAllClaimsFromToken(token);
            return claims.get(claimKey, String.class);
        }

        private Claims getAllClaimsFromToken(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }
    }

