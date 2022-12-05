
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("API")
public class APIController {
	@Autowired
	private WebClient.Builder webClient;
//	public String city = "bangalore";

	@GetMapping("/list")
	public ResponseEntity<ResponceData> getAPIDetilas() {
		ResponceData responce = new ResponceData();
		City city = webClient.build().get()
				.uri("https://623c81188e9af58789521b88.mockapi.io/data/1")

//				.accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(City.class)

				.block();
		System.out.println("------");
		
		responce.setCity(city);
		System.out.println(city.toString());
		System.out.println("------");

		API_Data c1 = webClient.build().get()
//						.uri("https://api.openweathermap.org/data/2.5/weather?q=Bangalore&appid=925de4d053c58897dd294965287d0594")
//						.uri("https://mocki.io/v1/bdf486c9-68f4-46a5-b52d-a1817a1b67d4")
				.uri("https://api.openweathermap.org/data/2.5/weather?q="+city.getCity()+"&appid=925de4d053c58897dd294965287d0594")
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(API_Data.class)

				.block();

		responce.setAPI(c1);
		return new ResponseEntity<ResponceData>(responce, HttpStatus.OK);

	}

}
