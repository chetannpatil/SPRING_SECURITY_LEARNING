package com.erpApp.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class MyUserDetailService implements UserDetailsService
{


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		System.out.println("\n MyUserDetailService UserDetails \n");
		// return sp security s User
		return new User("chetan","pass",new ArrayList<GrantedAuthority>());
	}

	
	 
}
