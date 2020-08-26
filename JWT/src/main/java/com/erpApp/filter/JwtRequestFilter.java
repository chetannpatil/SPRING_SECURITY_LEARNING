package com.erpApp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.erpApp.service.JwtUtil;
import com.erpApp.service.MyUserDetailService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter
{

	@Autowired
	MyUserDetailService myUserDetailService ;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		System.out.println("\n JwtRequestFilter doFilterInternal request = \n"+request
				+"response = \n "+response
				+"filterchain = \n "+filterChain);
		
		//xtract header from req
		final String authorizationheader = request.getHeader("Authorization");
		
		System.out.println(" aftre extratinf from request,  authorizationheader = \n "+authorizationheader);
		String userName = null;
		String jwt =null;
		
		if(authorizationheader != null && authorizationheader.startsWith("Bearer "))
		{
			System.out.println("\n yes this is not 1st time requst\n");
			
			jwt = authorizationheader.substring(7);
			System.out.println("\n authorizationheader.substring(7) = jwt = \n"+jwt);
			userName = jwtUtil.extractUsername(jwt);
			System.out.println("\n jwtUtil.extractUsername(jwt) = userName = \n"+userName);
		}
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			UserDetails userDetails = myUserDetailService.loadUserByUsername(userName);
			//checking jwt valid(username matches r not ) n jwt not expired
			if(jwtUtil.validateToken(jwt, userDetails))
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						
						new UsernamePasswordAuthenticationToken(userDetails,null,
								userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken
				.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
			 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);	
			}
			else
			{
				System.err.print("\n FAILED jwtUtil.validateToken(jwt, userDetails) validation\n");
			}
		
		}
		filterChain.doFilter(request, response);
	}

}
