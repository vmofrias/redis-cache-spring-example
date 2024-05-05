package com.ldsk.caching.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachingRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingRedisApplication.class, args);
	}

}
