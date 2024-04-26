package com.code.rest.entity;


import com.code.rest.repository.StudentRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.code.rest.repository.StudentRepository;

@Entity
@Table(name="new")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollNo;
	@Column(name="name")
	private String name;
	@Column
	private float percent;
	@Column
	private String branch;
	
	
	
	public Student() {
    }

	
	
	public Student(String name, float percent, String branch) {
		super();
		this.name = name;
		this.percent = percent;
		this.branch = branch;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percent=" + percent + ", branch=" + branch + "]";
	}
	
	

}
