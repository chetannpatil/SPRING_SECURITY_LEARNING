package com.erpApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class ErpAppApplication {

	public static void main(String[] args) 
	{
		System.out.println("erppp nain after creating all user");
		
		SpringApplication.run(ErpAppApplication.class, args);
				
	}

}
