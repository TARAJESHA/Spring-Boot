package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class APIDataApplication {
  @Bean
	public WebClient.Builder getWebClient(){
		return WebClient.builder();		
	}
	public static void main(String[] args) {
		
		System.setProperty("server.port", "8082");
		SpringApplication.run(APIDataApplication.class, args);
		
//		City s1=new City();
//		System.out.println(s1.getCity());		
//		WebClient.Builder builder=WebClient.builder();
//			String c1=builder.build()
//					.get()
//					.uri("https://api.openweathermap.org/data/2.5/weather?q=London&appid=925de4d053c58897dd294965287d0594")
//					.retrieve()
//					.bodyToMono(String.class)
//					.block();
			
			//System.out.println(c1.toString());
		System.out.println("**************************");
		
	}
}
