package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collage")
public class CollageControllers {
	@GetMapping("/{collageId}")
	public ResponseEntity<Collage> getCollageDetails(@PathVariable("collageId") int collageId){
		Collage cl=new Collage();
		cl.setCollageID(1);
		cl.setCollageName("New Horizon collage of Engg");
		cl.setAddress("Karnataka, Bangalore, Marathahalli");
		
		
		
		return new ResponseEntity<Collage>(cl, HttpStatus.OK);
		
	}
	

}
