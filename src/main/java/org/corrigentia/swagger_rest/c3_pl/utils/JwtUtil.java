package org.corrigentia.swagger_rest.c3_pl.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.corrigentia.swagger_rest.c3_pl.config.jwt.JwtConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	private final JwtConfig config;
	private final JwtBuilder builder;
	private final JwtParser parser;

	public JwtUtil(final JwtConfig config) {
		this.config = config;
		final SecretKey key = config.secretKey;
		this.builder = Jwts.builder().signWith(key);
		this.parser = Jwts.parserBuilder().setSigningKey(key).build();
		// this.parser = Jwts.parserBuilder().setSigningKey(key.getEncoded()).build();
	}

	public String generateToken(final UserDetails userDetails) {
		final Map<String, Object> claims = new HashMap<>(20);
		claims.put("roles",
				userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().toArray());

		System.out.println("generateToken(final UserDetails userDetails)");
		System.out.println("this.generateToken(claims, userDetails.getUsername()): "
				+ this.generateToken(claims, userDetails.getUsername()));
		return this.generateToken(claims, userDetails.getUsername());
	}

	public List<String> getAuthoritiesFromToken(final String token) {
		System.out.println("getAuthoritiesFromToken(final String token)");
		System.out.println("token: " + token);
		return this.getClaimFromToken(
				token,
				claims -> claims.get(
						"roles",
						List.class));
	}

	public <T> T getClaimFromToken(final String token, final Function<Claims, T> claimsResolver) {
		System.out.println("getClaimFromToken(final String token, final Function<Claims, T> claimsResolver)");
		// System.out.println("token: " + token);
		// System.out.println("this.getClaimsFromToken(token): " +
		// this.getClaimsFromToken(token));
		final Claims claims = this.getClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public Date getExpirationDateFromToken(final String token) {
		System.out.println("getExpirationDateFromToken(final String token)");
		System.out.println("token: " + token);
		return this.getClaimFromToken(token, Claims::getExpiration);
	}

	public String getUsernameFromToken(final String token) {
		System.out.println("getUsernameFromToken(final String token)");
		// System.out.println("token: " + token);
		return this.getClaimFromToken(token, Claims::getSubject);
	}

	public boolean isExpired(final String token) {
		System.out.println("isExpired(final String token)");
		System.out.println("token: " + token);
		final Date expiration = this.getClaimFromToken(token, Claims::getExpiration);
		return expiration.before(new Date());
	}

	public boolean validateToken(final String token, final UserDetails userDetails) {
		System.out.println("validateToken(final String token, final UserDetails userDetails)");
		System.out.println("token: " + token);
		final boolean hasSameSubject = this.getUsernameFromToken(token).equals(userDetails.getUsername());
		return !this.isExpired(token) && hasSameSubject;
	}

	private String generateToken(final Map<String, Object> claims, final String subject) {

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

		return this.builder.setClaims(claims).setSubject(subject).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + (this.config.expireAt * 1000L))).compact();
	}

	private Claims getClaimsFromToken(final String token) {
		System.out.println("getClaimsFromToken(final String token)");
		// System.out.println("token: " + token);
		// System.out.println("this.parser.parseClaimsJws(token): " +
		// this.parser.parseClaimsJws(token));
		/*
		 * System.out .println("this.parser.parseClaimsJws(token).getBody(): " +
		 * this.parser.parseClaimsJws(token).getBody());
		 */
		return this.parser.parseClaimsJws(token).getBody();
	}
}
