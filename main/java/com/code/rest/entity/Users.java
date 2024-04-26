package com.code.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")

public class Users {
	private String email;
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int age;
	private Boolean gender;
	private String password;
	public Users() {
    }
	
	public Users(String email, Long id, int age, Boolean gender,String password) {
		super();
		this.email = email;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.password= password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [email=" + email + ", id=" + id + ", age=" + age + ", gender=" + gender + "]";
	}
	
	

}
