package com.erpApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		System.out.println("\n SecurityConfig configure \n");
		auth.inMemoryAuthentication()
		.withUser("chetan")
		.password("pass")
		.roles("admin")
		.and()
		.withUser("vikram")
		.password("vicky")
		.roles("user")
		.and()
		.withUser("geetha")
		.password("1234")
		.roles("user")
		.and()
		.withUser("harish raj")
		.password("5678")
		.roles("user")
		.and()
		.withUser("vassuki")
				.password("1234")
				.roles("user");
		
		
		
		
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
		 
		 
		 //onty to admin
		/* 
		 * http.authorizeRequests() .antMatchers("/**") .hasRole("admin") .and()
		 * .formLogin();
		 */
		 
		 
	}
	
	
	 
	 
}
