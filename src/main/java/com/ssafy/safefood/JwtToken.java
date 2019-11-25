package com.ssafy.safefood;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

public class JwtToken {
	public static void main(String[] args) throws SignatureException, ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		String jws = Jwts.builder().setSubject("key").signWith(key).compact();
		
		System.out.println(jws);
		
		assert Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody().getSubject().equals("key");
	}
}
