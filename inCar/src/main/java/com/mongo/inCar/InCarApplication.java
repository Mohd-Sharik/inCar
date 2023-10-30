package com.mongo.inCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(InCarApplication.class, args);
	}

}
