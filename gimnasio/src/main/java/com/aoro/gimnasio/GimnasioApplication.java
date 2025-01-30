package com.aoro.gimnasio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.aoro.*")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GimnasioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GimnasioApplication.class, args);
	}

}
