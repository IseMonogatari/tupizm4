package com.example.Preproject;

import com.example.Preproject.model.Request;
import com.example.Preproject.model.Role;
import com.example.Preproject.model.User;
import com.example.Preproject.repository.RequestRepository;
import com.example.Preproject.repository.RolesRepository;
import com.example.Preproject.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		RolesRepository roleRepository = context.getBean(RolesRepository.class);
//		RequestRepository requestRepository = context.getBean(RequestRepository.class);

		roleRepository.save(new Role("ROLE_ADMIN"));
		roleRepository.save(new Role("ROLE_USER"));

//		User user = new User("w", "w", "w", "w", roles);
//
//		requestRepository.save(new Request(true, user));


//		SpringApplication.run(Application.class, args);
	}

}
