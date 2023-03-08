package com.example.share.config.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
    public static long JWT_TOKEN_VALIDITY;        ////  5 * 60 * 60;
    public static long refreshExpirationDateInMs;
    private static String secret;
    
	@Autowired
	private KeyStoreConfig keyStoreConfig;
    
	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		JwtUtil.secret = secret;
	}

	@Value("${jwt.JWT_TOKEN_VALIDITY}")
	public void setJwtExpirationInMs(int JWT_TOKEN_VALIDITY) {
		JwtUtil.JWT_TOKEN_VALIDITY = JWT_TOKEN_VALIDITY;
	}

	@Value("${jwt.refreshExpirationDateInMs}")
	public void setRefreshExpirationDateInMs(int refreshExpirationDateInMs) {
		JwtUtil.refreshExpirationDateInMs = refreshExpirationDateInMs;
	}
	
	public String extractUserEmail(String token)  {
		return extractClaim(token,Claims::getSubject);
	}
	
	public Date extractExpiration(String token)  {
		return extractClaim(token,Claims::getExpiration);
	}
	
	private boolean hasClaim(String token,String claimName)  {
		final Claims claims =extractAllClaims(token);
		return claims.get(claimName) != null;
	}
	
	public <T> T extractClaim(String token,Function<Claims, T> ClaimsResolver) {
		final Claims claims=extractAllClaims(token);
		return ClaimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(keyStoreConfig.getJwtSigningPrivateKey()).parseClaimsJws(token).getBody();
    }
	
	public boolean isTokenExpired(String token)  {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails);
	}
	public String generateToken(UserDetails userDetails , Map<String,Object> claims) {
		return createToken(claims,userDetails);
	}
	
	private String createToken(Map<String,Object> claims , UserDetails userDetails) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.claim("authorities", userDetails.getAuthorities())
				.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.RS256, keyStoreConfig.getJwtSigningPrivateKey()).compact();
	}
	
	public boolean isTokenValid(String token , UserDetails userDetails)  {
		final String userEmail=extractUserEmail(token);
		return (userEmail.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	

}
