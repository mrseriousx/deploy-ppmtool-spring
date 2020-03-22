package com.example.PPMToolSpring.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.PPMToolSpring.domain.User;
import com.example.PPMToolSpring.services.CustomUserDetailsService;


import static com.example.PPMToolSpring.security.SecurityConstants.*  ;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired 
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String jwt = getJWTFromRequest(httpServletRequest );
			
			if(StringUtils.hasText(jwt )&&tokenProvider.validateToken(jwt )) {
				Long userId = tokenProvider.getUserIdFromJWT(jwt );
				User userDetails = customUserDetailsService.loadUserById(userId);
				
				
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,Collections.emptyList());
			
			authentication.setDetails(new WebAuthenticationDetailsSource( ).buildDetails(httpServletRequest));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			}
		}catch(Exception e) {
			logger.error("could not set user authentication in security context ",e );
			
			
		}
		
		filterChain.doFilter(httpServletRequest, response);
		
	}
	
	private String getJWTFromRequest(HttpServletRequest request ) {
		String bearerToken = request.getHeader(HEADER_STRING );
		
		if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX )) {
			return bearerToken.substring(7,bearerToken.length());
			
		}
		return null;
		
	}

}
