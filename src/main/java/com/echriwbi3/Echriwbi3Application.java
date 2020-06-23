package com.echriwbi3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class Echriwbi3Application {

	public static void main(String[] args) {
		SpringApplication.run(Echriwbi3Application.class, args);

	}

}
