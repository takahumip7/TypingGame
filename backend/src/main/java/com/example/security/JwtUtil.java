package com.example.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret"; // 32文字以上
	private final long EXPIRATION_TIME = 1000 * 60 * 60; //1時間
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	// トークン生成
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(key)
				.compact();
	}
	
	// クレーム抽出
	public Claims extractClaims(String token) {
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	//ユーザー名取得
	public String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}
	
	// トークン有効性チェック
	public boolean validateToken(String token, String username) {
		return (username.equals(extractUsername(token)) && !isTokenExpired(token));
	}
	
	private boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date());
	}
}
