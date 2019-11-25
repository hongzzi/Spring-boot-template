package com.ssafy.safefood.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ssafy.safefood.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtServiceImpl implements JwtService {

	private final Key key =  Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private Long expireMin;
	
	@Override
	public String create(User user) {
		log.trace("time: {}" , expireMin);
		final JwtBuilder builder = Jwts.builder();
		// 헤더 명시
		builder.setHeaderParam("typ", "JWT");
		// 토큰 제목
		builder.setSubject("로그인토큰")
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*expireMin))
			.claim("User", user);
		// 시크릿 키 
		builder.signWith(key);
		
		final String jwt = builder.compact();
		log.debug("토큰 발행: {}", jwt);
		return jwt;
	}

	/**
	 * 만약 문제있을시 (토큰 유효 X) 런타임에러남
	 */
	@Override
	public void checkValid(String jwt) {
		log.trace("토큰 점검 : {}", jwt);
		Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
	}

	@Override
	public Map<String, Object> get(final String jwt) {
		Jws<Claims> claims = null;
		
		try {
			claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
			
		} catch(final Exception e) {
			throw new RuntimeException();
		}
		
		log.trace("claim: {}", claims);
		return claims.getBody();
	}

}
