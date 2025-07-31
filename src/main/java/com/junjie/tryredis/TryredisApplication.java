package com.junjie.tryredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class TryredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryredisApplication.class, args);
	}

}
