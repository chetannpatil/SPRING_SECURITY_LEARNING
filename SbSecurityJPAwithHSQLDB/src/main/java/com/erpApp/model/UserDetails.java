package com.erpApp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails
{

	private String userName;
	
	private String password;
	
	private boolean active ;
	
	private String roles;
	
	private List<GrantedAuthority>  auList = new ArrayList<GrantedAuthority>();
	
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<GrantedAuthority> getAuList() {
		return auList;
	}

	public void setAuList(List<GrantedAuthority> auList) {
		this.auList = auList;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails(String userName) {
		super();
		this.userName = userName;
	}

	public UserDetails(User user) 
	{
		System.out.println("\n UserDetails(User user)  user = \n"+user);
		this.userName = user.getUserName();
		
		this.password = user.getPassword();
		
		this.active = user.isActive();
		
		String[] rolesArray = user.getRoles().split(",");
		
		for(String s:rolesArray)
		{
			System.out.println("\n for role = \n"+s);
			this.auList.add(new SimpleGrantedAuthority(s));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return this.auList;
	}

	@Override
	public String getPassword() 
	{
		return this.password;
	}

	@Override
	public String getUsername()
	{
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.active;
	}



	
}
