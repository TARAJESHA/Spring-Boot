package com.example.demo;


public class ResponceData {
	private API_Data api_data;
	@SuppressWarnings("unused")
	private City city;
	
	public API_Data getAPI() {
		return api_data;
	}
	public void setAPI(API_Data  c1) {

		this.api_data =  c1;
	}
	public void setCity(City city) {
		this.city=city;
		
	}
	public City getCity(City city) {
		return city;
	}

	
	

}
