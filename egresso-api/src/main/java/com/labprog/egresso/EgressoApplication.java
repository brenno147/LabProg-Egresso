package com.labprog.egresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class EgressoApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry cors) {
		cors.addMapping("/**")
			.allowedMethods("GET", "PUT", "DELETE", "POST");
	}

	public static void main(String[] args) {
		SpringApplication.run(EgressoApplication.class, args);
	}
}
