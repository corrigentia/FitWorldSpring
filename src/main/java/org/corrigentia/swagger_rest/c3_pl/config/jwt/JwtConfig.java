package org.corrigentia.swagger_rest.c3_pl.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    public int expireAt = 86_400;
    public SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
}
