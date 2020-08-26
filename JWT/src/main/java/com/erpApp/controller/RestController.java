package com.erpApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erpApp.model.AuthenticationRequest;
import com.erpApp.model.AuthenticationResponse;
import com.erpApp.service.JwtUtil;
import com.erpApp.service.MyUserDetailService;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Autowired
	JwtUtil jwtTokenUtil ;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createaAthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception
	{
		System.out.println("\n RC createaAthenticationToken() \n");
		

		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
					authenticationRequest.getPassword()) );
		}
		catch (BadCredentialsException e) 
		{
			e.printStackTrace();
			System.out.println("\n RC createaAthenticationToken( ) BadCredentialsException e =  \n"+e.getLocalizedMessage());
			
			throw new Exception("Incorrect usrenm / passowrd",e);
		}
		
		final UserDetails userDetails =
				myUserDetailService.loadUserByUsername(authenticationRequest.getUserName());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping(value = "/hello")
	public String userdetaHello()
	{
		System.out.println("RC userdetaHello \n");
		
		return "yes its hello  ";
	}
	
	@GetMapping(value = "/")
	public String khali()
	{
		System.out.println("RC khali \n");
		
		return "yes its khali  ";
	}
	
	@GetMapping(value = "/admin/details")
	public String getAdminDetails()
	{
		System.out.println("RC getAdminDetails \n");
		
		return "yes its mdin details page ";
	}
	
	@GetMapping(value = "/admin")
	public String getAdmin()
	{
		System.out.println("RC getAdmin \n");
		
		return "yes its mdin hello home page ";
	}
	
	

	
	
	//users
	

	@GetMapping(value = "/user")
	public String user()
	{
		System.out.println("RC user \n");
		
		return "yes its user hello home page ";
	}
	
	@GetMapping(value = "/user/details")
	public String userdeta()
	{
		System.out.println("RC userdeta \n");
		
		return "yes its userdeta  derailslls  ";
	}
	
	

	
	
	
	
	
	
}
