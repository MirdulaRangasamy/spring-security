package com.exterro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.exterro.model.Car;
import com.exterro.model.User;
import com.exterro.repository.CarRepository;
import com.exterro.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CarRepository carRepo, UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User("user", encoder.encode("password"), "ROLE_USER"));
			users.save(new User("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
			carRepo.save(new Car("TN66C7689", "TIAGO", "RAGHU", 100000.0));
			carRepo.save(new Car("TN38G8888", "ALTRAZ", "SHYAM", 150000.0));
		};
	}

}
