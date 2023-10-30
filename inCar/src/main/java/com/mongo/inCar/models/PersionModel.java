package com.mongo.inCar.models;

import java.io.Serializable;

public class PersionModel implements Serializable{
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String city;
	private String college;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
		return "PersionModel [id=" + id + ", name=" + name + ", city=" + city + ", college=" + college + "]";
	}
	
	
	
	

}
