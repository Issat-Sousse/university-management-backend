package com.IssatSo.AppWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//pour n'est pas demander a chaque fois la login de la securite
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AppWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWebApplication.class, args);
	}

}
