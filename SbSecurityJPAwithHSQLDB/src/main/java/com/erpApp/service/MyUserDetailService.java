package com.erpApp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.erpApp.dao.UserDao;
import com.erpApp.model.User;
import com.erpApp.model.UserDetails;

@Service
public class MyUserDetailService implements UserDetailsService
{

	@Autowired
	private UserDao userDao;
	
	
	  @Override
	  public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException 
	  {
		 // return new UserDetails(username);
		  
		  Optional<User> optional = userDao.findByUserName(username);
		  
		  User user = optional.get();
		  
		  System.out.println("MyUserDetailService loadUserByUsername user = \n" +user);
		  if(user == null)
		  {
			  System.out.println("\n user == null \n");
			  throw new UsernameNotFoundException("the user "+username+" not available ");
		  }
		  UserDetails userDetails = new UserDetails(user);
		  
		  return userDetails;
	  }
	 
}
