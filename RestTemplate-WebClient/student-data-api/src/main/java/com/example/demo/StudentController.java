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
@RequestMapping("student")
public class StudentController {
	@SuppressWarnings("unused")
	@Autowired
	private WebClient.Builder webClient;
	
	
	@GetMapping("/{studentId}")
	public ResponseEntity<ResponceData> getStudentDetilas (@PathVariable("studentId") int studentId){
		ResponceData responce=new ResponceData()
;		
		Student sl=new Student();
		sl.setStudentName("Rajesh");
		sl.setStudentId(1);
		sl.setBranch("ECE");
		sl.setSemister("Vl");
		responce.setStudent(sl);
		
		int StudentId=sl.getStudentId();
		
		//RestTemplate
		/*RestTemplate restTemplate=new RestTemplate();
		String endPoint="http://localhost:8081/collage/{StudentId}";

		ResponseEntity<Collage> data=restTemplate.getForEntity(endPoint, Collage.class, StudentId);
		if(data.getStatusCodeValue()==200) {
			
			Collage c1=data.getBody();
			responce.setCollage(c1);
			
		}*/ 
		//RestTemplate
		
		//WebClient
		Collage c1=webClient.build()
				.get()
				.uri("http://localhost:8081/collage/"+StudentId)
				.retrieve()
				.bodyToMono(Collage.class)
				.block();
		
		responce.setCollage(c1);
		
		
		return new ResponseEntity<ResponceData>(responce, HttpStatus.OK);
		
	}
	

}
