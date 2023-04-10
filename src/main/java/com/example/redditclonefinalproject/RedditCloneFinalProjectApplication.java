package com.example.redditclonefinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditCloneFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneFinalProjectApplication.class, args);
	}

}
