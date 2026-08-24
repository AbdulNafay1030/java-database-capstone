package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {

    private static final String SECRET_PREFIX = "JWT_SMART_CLINIC_";

    public String generateToken(String username, String role) {
        long now = System.currentTimeMillis();
        long expiry = now + (3600 * 1000); // 1 hour validity
        return SECRET_PREFIX + UUID.randomUUID().toString() + "_" + username + "_" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith(SECRET_PREFIX);
    }
}
