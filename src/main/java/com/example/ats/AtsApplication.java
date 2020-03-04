package com.example.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtsApplication.class, args);
	}

}
