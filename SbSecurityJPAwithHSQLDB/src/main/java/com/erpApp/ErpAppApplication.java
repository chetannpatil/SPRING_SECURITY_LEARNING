package com.erpApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.erpApp.dao.UserDao;
import com.erpApp.model.User;
import com.erpApp.service.UserService;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
//@EnableJpaRepositories(basePackageClasses = UserDao.class)
public class ErpAppApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ErpAppApplication.class, args);
		
		UserService userService = applicationContext.getBean("userService", UserService.class);
		
		//creating & inserting few users
				User user1 = new User();
				user1.setUserName("Chetan");
				user1.setPassword("c");
				user1.setRoles("ROLE_user");
				user1.setActive(true);
				
				
				
				//user2 
				User user2 = new User();
				user2.setUserName("vikram");
				user2.setPassword("v");
				user2.setRoles("ROLE_admin");
				user2.setActive(true);
				
				//user3 
			//	User user3 = new User();
			
				
				//user4 
			//	User user4 = new User();
		
				
				//create all users
				userService.createUser(user1);
				userService.createUser(user2);
		/*
		 * userService.createUser(user3); userService.createUser(user4);
		 */
				System.out.println("erppp nain after creating all user");
				
				
				
	}

}
