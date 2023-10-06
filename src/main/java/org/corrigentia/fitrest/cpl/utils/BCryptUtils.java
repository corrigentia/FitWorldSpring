package org.corrigentia.fitrest.cpl.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptUtils {
    private final PasswordEncoder passwordEncoder;

    public BCryptUtils(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hash(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean verify(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
