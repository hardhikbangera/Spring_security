package com.example.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	private static final String secretKey="the-longest-secret-key-that-is very secure";


	public String getToken(String user) {
		Map<String , Object> map=new HashMap<>();
		return Jwts.builder()
				.claims(map)				
				.subject(user)				
				.signWith(getkey())
				.compact();
	}

	public Key getkey() {
		
		return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	}
}
