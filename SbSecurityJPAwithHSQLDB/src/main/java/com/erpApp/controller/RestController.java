package com.erpApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erpApp.model.User;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	
	
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
