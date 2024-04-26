package com.code.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {
	@Id
	@Column(name="adminid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;
	
	public Admin() {
		
	}
	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	

}
