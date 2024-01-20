package com.example.share.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authHeader = request.getHeader("Authorization");
		final String userEmail;
		final String jwtToken;
		
		if(authHeader==null || !authHeader.startsWith("Bearer")  ) {
			filterChain.doFilter(request, response);
			return;
		}
		System.out.println(13);
		jwtToken=authHeader.substring(7);
		
		userEmail=jwtUtil.extractUserEmail(jwtToken);
		if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails=userDetailServiceImpl.loadUserByUsername(userEmail);
			if(jwtUtil.isTokenValid(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken authToken =
						new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}else {
				System.out.println("TOKEN IS NOT VALID ................");
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
