package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollageDataApi1Application {

	public static void main(String[] args) {
		System.setProperty("server.port", "8081");
		SpringApplication.run(CollageDataApi1Application.class, args);


	}

}
