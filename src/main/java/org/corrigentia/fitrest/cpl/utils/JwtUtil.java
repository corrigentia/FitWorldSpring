package org.corrigentia.fitrest.cpl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.corrigentia.fitrest.adal.domain.entity.security.UserEntity;
import org.corrigentia.fitrest.cpl.config.jwt.JwtConfig;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private final JwtConfig config;
    private final JwtBuilder builder;
    private final JwtParser parser;

    public JwtUtil(JwtConfig config) {
        this.config = config;
        SecretKey key = config.secretKey;
        builder = Jwts.builder().signWith(key);
        parser = Jwts.parserBuilder().setSigningKey(key).build();
        // this.parser = Jwts.parserBuilder().setSigningKey(key.getEncoded()).build();
    }

    /*
     * public String generateToken(UserDetails userDetails) {
     * Map<String, Object> claims = new HashMap<>(20);
     * claims.put("roles",
     * userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).
     * toList().toArray());
     *
     * System.out.println("generateToken(final UserDetails userDetails)");
     * System.out.println("this.generateToken(claims,
     * userDetails.getUsername()):
     * "
     * + generateToken(claims, userDetails.getUsername()));
     * return generateToken(claims, userDetails.getUsername());
     * }
     */
    public String generateToken(UserEntity user) {
        return builder
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt * 1_000L))
                .compact();
    }

    public Claims getClaims(String token) {
        System.out.println("in JwtUtil.getClaims: token");
        System.out.println(token);
        System.out.println(parser.parseClaimsJws(token));
        System.out.println(parser.parseClaimsJws(token).getBody());

        return parser.parseClaimsJws(token).getBody();
    }

    public long getId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public String getEmail(String token) {
        System.out.println("in JwtUtil.getEmail: token");
        System.out.println(token);
        return getClaims(token).get("email", String.class);
    }

    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token) {
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRole(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }

    // removed because it returned null...
    /*
     * public <T> T getClaimFromToken(String token, Function<Claims, T>
     * claimsResolver) {
     * System.out.
     * println("getClaimFromToken(final String token, final Function<Claims, T> claimsResolver)"
     * );
     * // System.out.println("token: " + token);
     * // System.out.println("this.getClaimsFromToken(token): " +
     * // this.getClaimsFromToken(token));
     * System.out.println("token: \n" + token);
     * Claims claims = getClaimsFromToken(token);
     * System.out.println(claims);
     * System.out.println(claimsResolver);
     * System.out.println(claimsResolver.apply(claims)); // null
     * return claimsResolver.apply(claims); // null
     * }
     */

    // removed because it depended on bad code
    /*
     * public List<String> getAuthoritiesFromToken(String token) {
     * System.out.println("getAuthoritiesFromToken(final String token)");
     * System.out.println("token: " + token);
     * return getClaimFromToken(
     * token,
     * claims -> claims.get(
     * "roles",
     * List.class));
     * }
     *
     * public Date getExpirationDateFromToken(String token) {
     * System.out.println("getExpirationDateFromToken(final String token)");
     * System.out.println("token: " + token);
     * return getClaimFromToken(token, Claims::getExpiration);
     * }
     *
     * public String getUsernameFromToken(String token) {
     * System.out.println("getUsernameFromToken(final String token)");
     * System.out.println("token: \n" + token);
     * System.out.println(getClaimFromToken(token, Claims::getSubject));
     * return getClaimFromToken(token, Claims::getSubject);
     * }
     *
     * public boolean isExpired(String token) {
     * System.out.println("isExpired(final String token)");
     * System.out.println("token: " + token);
     * Date expiration = getClaimFromToken(token, Claims::getExpiration);
     * return expiration.before(new Date());
     * }
     */

    // removed because it depended on code that depended on bad method
    /*
     * public boolean validateToken(String token, UserDetails userDetails) {
     * System.out.
     * println("validateToken(final String token, final UserDetails userDetails)");
     * System.out.println("token: " + token);
     * boolean hasSameSubject =
     * getUsernameFromToken(token).equals(userDetails.getUsername());
     * return !isExpired(token) && hasSameSubject;
     * }
     */

    private String generateToken(Map<String, Object> claims, String subject) {

        System.out.println("generateToken(final Map<String, Object> claims, final String subject)");

        // commenting this prevents it from giving authorization: null header, but I now
        // have JWT Signature Exception
        /*
         * System.out.println(
         * "this.builder.setClaims(claims).setSubject(subject).setIssuedAt(new Date()) 				.setExpiration(new Date(System.currentTimeMillis() + (this.config.expireAt * 1000L))).compact(): "
         * + this.builder.setClaims(claims).setSubject(subject).setIssuedAt(new Date())
         * .setExpiration(new Date(System.currentTimeMillis() + (this.config.expireAt *
         * 1000L))) .compact());
         */

        return builder.setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (config.expireAt * 1000L))).compact();
    }

    private Claims getClaimsFromToken(String token) {
        System.out.println("getClaimsFromToken(final String token)");
        // System.out.println("token: " + token);
        // System.out.println("this.parser.parseClaimsJws(token): " +
        // this.parser.parseClaimsJws(token));
        /*
         * System.out .println("this.parser.parseClaimsJws(token).getBody(): " +
         * this.parser.parseClaimsJws(token).getBody());
         */
        return parser.parseClaimsJws(token).getBody();
    }
}
