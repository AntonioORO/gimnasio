package com.aoro.gimnasio.config.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aoro.gimnasio.config.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain)
            throws ServletException, IOException,ExpiredJwtException,AccessDeniedException {
    	
    	
    	try{
    		 final String authHeader = req.getHeader("Authorization");
    	        final String jwt;
    	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
    	            chain.doFilter(req, res);
    	            return;
    	        }
    	        jwt = authHeader.substring(7);
    	        String username=null;
    	        try {
    	         username = jwtService.extractUsername(jwt);
    	        }catch (Exception e) {
				
				}
    	        
    	        if (username != null) {
    	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    	            UsernamePasswordAuthenticationToken authenticationToken =
    	                    new UsernamePasswordAuthenticationToken(
    	                            userDetails,
    	                            null,
    	                            userDetails.getAuthorities()
    	                    );
    	            SecurityContextHolder
    	                    .getContext()
    	                    .setAuthentication(authenticationToken);
    	        }
    	        chain.doFilter(req, res);
    	 }catch (SignatureException ex){
    	    throw new OnlineStoreAPIException(HttpStatus.UNAUTHORIZED, "Invalid JWT signature");
    	 }
    	 catch (MalformedJwtException ex){
    	    throw new OnlineStoreAPIException(HttpStatus.UNAUTHORIZED, "Invalid JWT token");
    	 }
    	catch (OnlineStoreAPIException ex){
    	    throw new OnlineStoreAPIException(HttpStatus.UNAUTHORIZED, "Expired JWT token");
    	 }
    	 catch (UnsupportedJwtException ex){
    	    throw new OnlineStoreAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
    	 }
    	 catch (IllegalArgumentException ex){
    	    throw new OnlineStoreAPIException(HttpStatus.BAD_REQUEST, "JWT claims string is    empty");
    	   }
    	 catch (ExpiredJwtException ex){
     	    throw new AccessDeniedException("ExpiredJwtException");
     	   }
    	
    	
    	
       
    }
}


