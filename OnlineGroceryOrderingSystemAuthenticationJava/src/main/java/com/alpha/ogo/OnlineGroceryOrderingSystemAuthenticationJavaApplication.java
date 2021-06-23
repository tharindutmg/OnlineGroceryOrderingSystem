package com.alpha.ogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing
@EnableJpaRepositories
public class OnlineGroceryOrderingSystemAuthenticationJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGroceryOrderingSystemAuthenticationJavaApplication.class, args);
	}

}
