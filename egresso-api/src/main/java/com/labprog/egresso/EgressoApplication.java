package com.labprog.egresso;

import com.labprog.egresso.model.repositories.EgressoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EgressoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgressoApplication.class, args);
	}
}
