package com.BancoLALR.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan (basePackages = "com.BancoLALR.springboot.app.*")
@EntityScan("com.BancoLALR.springboot.app.*")
@EnableJpaRepositories(basePackages = "com.BancoLALR.springboot.app.repository")
public class BancoLalrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoLalrApplication.class, args);
	}

}
