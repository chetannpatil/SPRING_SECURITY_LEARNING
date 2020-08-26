package com.erpApp.config;

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

	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception { auth.inMemoryAuthentication()
	  .withUser("VIRAT").password("v").roles("user") .and()
	  .withUser("vikram").password("v").roles("admin"); }
	 
	
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder a) throws
	 * Exception { a.inMemoryAuthentication().withUser("VIRAT").roles("user");
	 * 
	 * 
	 * a.inMemoryAuthentication().withUser("vikram").roles("admin");
	 * 
	 * }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		 .authorizeRequests()
		//.antMatchers("/user","/user/**","/admin","/admin/**").hasRole("admin")
		.antMatchers("/user","/user/**").hasAnyRole("user","admin")
		.antMatchers("/admin","/admin/**").hasRole("admin")
		.and()
		.formLogin();
	}

	  @Bean 
	  public PasswordEncoder getPasswordEncoder()
	  {
	    System.out.println("\n SecurityConfig getPasswordEncoder  \n");
	  
	     return  NoOpPasswordEncoder.getInstance();
	  }
}
