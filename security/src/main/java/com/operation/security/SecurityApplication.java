package com.operation.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.operation.model.Post;
import com.operation.model.User;
import com.operation.repository.PostRepository;
import com.operation.repository.UserRepository;

@SpringBootApplication
@ComponentScan("com.operation.controller")
@ComponentScan("com.operation.userdetailservice")
@ComponentScan("com.operation.Service")
@ComponentScan("com.operation.config")
@EntityScan("com.operation.model")
@EnableJpaRepositories("com.operation.repository")
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	
//	  @Bean CommandLineRunner commandLineRunner(PostRepository posts,UserRepository users, PasswordEncoder encoder) { 
//		  return args -> {
//	  users.save(new User("user",encoder.encode("password"),"ROLE_USER"));
//	  users.save(new User("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN")); }; 
//	  
//	  }
	 
}
