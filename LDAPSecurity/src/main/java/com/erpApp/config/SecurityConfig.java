package com.erpApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		System.out.println("\n SecurityConfig configure  wit dsourc = \n"+dataSource);
	
		auth.ldapAuthentication()
		//dn stands for distngiush names
		.userDnPatterns("uid={0},ou=people")
		.groupSearchBase("ou=groups")
		.contextSource()
		.url("ldap://localhost:8389/dc=springframework,dc=org")//where ldpa server is hosted with same domain compenet(dc)
		.and()
		.passwordCompare()
		.passwordEncoder(new LdapShaPasswordEncoder())//not recommended for production
		.passwordAttribute("userPassword");
		
		
		
		  
		
	}
	  
	  @Bean
	  public PasswordEncoder getPasswordEncoder()
	  {
	    System.out.println("\n SecurityConfig getPasswordEncoder  \n");
	  
	     return  NoOpPasswordEncoder.getInstance();
	  }
	  
	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		 System.out.println("\n SecurityConfig  configure(HttpSecurity http)  \n");
		 
		 http.authorizeRequests()
		 .anyRequest().fullyAuthenticated()
		 .and()
		 .formLogin();
			 
	}
	
	
	 
	 
}
