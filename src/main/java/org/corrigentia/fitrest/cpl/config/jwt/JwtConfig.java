package org.corrigentia.fitrest.cpl.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    public int expireAt = 86_400;
    public SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public int expireAt2 = 86_400 * 7; // 7 days
    private final byte[] secret =
            "Yabadabadoooooooooooooooooooooooooooooooooooooo".getBytes();
    public SecretKey secretKey2 = new SecretKeySpec(secret, "HmacSHA384");
}
