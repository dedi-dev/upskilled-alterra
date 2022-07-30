package com.upskilled.taskjwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.upskilled.taskjwt.domain.AppUser;
import com.upskilled.taskjwt.domain.Role;
import com.upskilled.taskjwt.service.AppUserService;

@SpringBootApplication
public class TaskjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskjwtApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(AppUserService appUserService) {

		return args -> {

			appUserService.saveUser(new AppUser(null, "Fajar Satriatna", "081234567890",
					"123123123", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "James Arthur", "081313132424",
					"james123", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Harry Styles", "085746462525",
					"harry123", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Dua Lipa", "085762621313",
					"dualipa123", new ArrayList<>()));

			appUserService.saveRole(new Role(null, "ROLE_USER"));
			appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
			appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
			appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			appUserService.addRoleToUser("081234567890", "ROLE_USER");
			appUserService.addRoleToUser("081313132424", "ROLE_MANAGER");
			appUserService.addRoleToUser("085746462525", "ROLE_ADMIN");
			appUserService.addRoleToUser("085762621313", "ROLE_SUPER_ADMIN");
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
