package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("API")
public class APIController {
	@Autowired
	private WebClient.Builder webClient;

	@GetMapping("/list")
	public ResponseEntity<ResponceData> getAPIDetilas (){
		ResponceData responce=new ResponceData();		
		
		API_Data[] c1=webClient.build()
				.get()
				.uri("https://jsonplaceholder.typicode.com/posts")
				.retrieve()
				.bodyToMono(API_Data[].class)
				.block();
		
		responce.setAPI(c1);
		return new ResponseEntity<ResponceData>(responce, HttpStatus.OK);
		
	}
	

}
