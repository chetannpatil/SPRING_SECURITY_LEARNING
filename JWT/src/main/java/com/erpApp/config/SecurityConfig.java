package com.erpApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.erpApp.filter.JwtRequestFilter;
import com.erpApp.service.MyUserDetailService;

import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private MyUserDetailService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		System.out.println("\n SecurityConfig configure  wit dsourc = \n");
		
		  auth.userDetailsService(myUserDetailsService);
	
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
	  

	  //csrf = crss site request forgery
	  http.csrf().disable()
	  // permit directly (means those who havle alredy atheticated once to app) to this URl pattern
	  .authorizeRequests().antMatchers("/authenticate").permitAll()
	  .anyRequest().authenticated()
	  .and()
	  //tell spring security to not to create session
	  .sessionManagement()
	  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  //then there must be something which works n sets security context each time
	  //i.e add filter b4 calling usnam pswd authentctaionFilter
	  http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	  
	  
	  }
	 
	   //to enable AuthenticationManager in our  Restcontroller as a has a
	   @Override
	   @Bean
	   public AuthenticationManager authenticationManagerBean() throws Exception 
	   {
		   System.out.println("\n SecurityConfig  authenticationManagerBean  \n");
		return super.authenticationManagerBean();
	   }
	
	 
	 
}
