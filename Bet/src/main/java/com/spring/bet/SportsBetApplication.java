package com.spring.bet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.spring.bet.repo")
@EntityScan(basePackages={"com.spring.bet.entity"})
public class SportsBetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsBetApplication.class, args);
	}

}
