package com.aoro.gimnasio.config.auth;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	public JwtBuilder generateToken(Authentication authentication) {

		Calendar cal = Calendar.getInstance(Locale.US);
		Calendar cal1 = Calendar.getInstance(Locale.US);
		cal1.setTime(cal.getTime());
		cal1.add(Calendar.SECOND, expiration);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return Jwts.builder().setSubject(userDetails.getUsername()).claim("roles", getRoles(userDetails))
				.setIssuedAt(cal.getTime())
				.setExpiration(cal1.getTime()).signWith(getKey(secret));
	}

	public String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey(secret)).build().parseClaimsJws(token).getBody().getSubject();
	}

	public Date extractExpiration(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey(secret)).build().parseClaimsJws(token).getBody()
				.getExpiration();
	}

	private List<String> getRoles(UserDetails userDetails) {
		return userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	}

	private Key getKey(String secret) {
		byte[] secretBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(secretBytes);
	}
}
