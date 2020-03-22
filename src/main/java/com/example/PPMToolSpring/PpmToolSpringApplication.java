package com.example.PPMToolSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//(exclude = {HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories

public class PpmToolSpringApplication {

	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PpmToolSpringApplication.class, args);
	}

}
