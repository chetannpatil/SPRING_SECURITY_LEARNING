package com.erpApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		System.out.println("\n SecurityConfig configure  wit dsourc = \n"+dataSource);
		
		  auth.jdbcAuthentication()
		  .dataSource(dataSource);
		  
		
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
		     .antMatchers("/admin","/admin/**")
		    .hasRole("admin")
		    .antMatchers("/user","/user/**")
		    .hasRole("user")
		    .antMatchers("static/css","static/js").permitAll()
		    .antMatchers("/").permitAll()
		    .and()
		    .formLogin();
			 
	}
	
	
	 
	 
}
