package com.example.demo.Todo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Todo {
	@Id
	Integer id;
	String name;
	String summary;
	String Discription;
	public Todo(Integer id, String name, String summary, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		Discription = discription;
	}
	public Todo() {
		
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
}
