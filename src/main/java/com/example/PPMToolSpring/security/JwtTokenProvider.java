//package com.example.PPMToolSpring.security;
//
//import static com.example.PPMToolSpring.security.SecurityConstants.EXPIRATION_TIME;
//import static com.example.PPMToolSpring.security.SecurityConstants.*  ;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.security.core.Authentication;
//
//import com.example.PPMToolSpring.domain.User;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JwtTokenProvider {
//	
//	//Generate token
//	public String generateToken(Authentication authentication ) {
//		User user = (User ) authentication.getPrincipal();
//		Date now = new Date(System.currentTimeMillis());
//		
//		Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME );
//		
//		String userId = Long.toString(user.getId ());
//		
//		
//		Map<String,Object > claims = new HashMap<>();
//		claims.put("id" ,Long.toString(user.getId ()) );
//		claims.put("username" ,user.getUsername () );
//		claims.put("fullName" ,user.getFullName () );
//
//		
//
//		return Jwts.builder()
//				.setSubject(userId )
//				.setClaims(claims )
//				.setIssuedAt(now )
//				.setExpiration(expiryDate)
//				.signWith(SignatureAlgorithm.HS512 , SECRET )
//				.compact();
//		
//	
//	
//	//Validate token
//	
//	
//	//Get user id from token
//	}
//} 
