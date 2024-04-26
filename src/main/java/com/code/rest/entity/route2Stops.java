package com.code.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="R2")
public class route2Stops implements Stop{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long sid;
	private String name;

	
	
	public route2Stops() {
		super();
	}
	public route2Stops(String name, String route) {
		super();
		this.name = name;
		
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public void update() {
		System.out.println("This is a r2 route Stop");
	}
	

}
