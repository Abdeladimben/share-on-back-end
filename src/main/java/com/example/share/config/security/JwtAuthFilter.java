package com.example.share.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.share.enums.ErrorCode;
import com.example.share.exception.ErrorDetail;
import com.example.share.exception.TokenIsNotValidException;

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
		String userEmail = null;
		final String jwtToken;
		
		if(authHeader==null || !authHeader.startsWith("Bearer")  ) {
			filterChain.doFilter(request, response);
			return;
		}
		System.out.println(13);
		jwtToken=authHeader.substring(7);
		
		try {
			userEmail=jwtUtil.extractUserEmail(jwtToken);
		} catch (TokenIsNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails=userDetailServiceImpl.loadUserByUsername(userEmail);
			try {
				if(jwtUtil.isTokenValid(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken authToken =
							new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}else {
					setErrorResponse(HttpStatus.UNAUTHORIZED, response);
				}
			} catch (TokenIsNotValidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		filterChain.doFilter(request, response);
		
	}
	
    public void setErrorResponse(HttpStatus status, HttpServletResponse response){
        response.setStatus(status.value());
        response.setContentType("application/json");
        // A class used for errors
        ErrorDetail errorDetail = new ErrorDetail(ErrorCode.T001);
        try {
            String json = errorDetail.convertToJson();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
