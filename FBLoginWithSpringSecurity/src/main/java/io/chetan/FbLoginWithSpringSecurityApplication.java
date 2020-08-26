package io.chetan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
@EnableOAuth2Sso
public class FbLoginWithSpringSecurityApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(FbLoginWithSpringSecurityApplication.class, args);
		System.out.println("\nafter FbLoginWithSpringSecurityApplication main()\n");
	}

}
