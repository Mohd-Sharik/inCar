package com.mongo.inCar.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Players")
public class PersionEntity {
	
	

	@Id
	private Long id;
	private String name;
	private String city;
	private String college;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	
	
	@Override
	public String toString() {
		return "PersionEntity [id=" + id + ", name=" + name + ", city=" + city + ", college=" + college + "]";
	}
	
	
	
	
	
	

}
