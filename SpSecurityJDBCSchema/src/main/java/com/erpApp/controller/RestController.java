package com.erpApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erpApp.model.User;
import com.erpApp.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	private UserService userService;
	
	
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
	
	
	@GetMapping(value = "admin/getByLastName/{lastName}")
	public List<User> findByLastName(@PathVariable("lastName") String lastName)
	{
		return userService.findByLastName(lastName);
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
	
	
	@GetMapping(value = "user/find/{adharNumber}")
	public User getByAdhar(@PathVariable("adharNumber") String adharNumber)
	{
		return userService.getByAdhar(adharNumber);
	}
	

	
	@GetMapping(value = "/")
	public List<User> findByLastName2()
	{
		String lastName = "Patil";
		return userService.findByLastName(lastName);
	}



	
	
}
