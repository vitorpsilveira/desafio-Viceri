package br.com.desafio.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BizuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BizuApplication.class, args);
	}

}
