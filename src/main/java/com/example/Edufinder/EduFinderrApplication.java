package com.example.Edufinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EduFinderrApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduFinderrApplication.class, args);
	}

}
