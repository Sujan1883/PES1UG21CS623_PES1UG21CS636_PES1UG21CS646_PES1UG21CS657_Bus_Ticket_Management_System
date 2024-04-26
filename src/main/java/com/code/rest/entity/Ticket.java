package com.code.rest.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="TICKET")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pnr;
	
	private Boolean status=true;
	private String type="upi";
	private String st_name;
	private String dt_name;
	private String name;
	private double amount;
	
	@Column(name = "bought_time")
    private LocalDateTime boughtTime;
	
	
	public Ticket() {
		
	}
	public Ticket(Boolean status, String type, String st_name, String dt_name, String name, double amount) {
		super();
		this.status = status;
		this.type = type;
		this.st_name = st_name;
		this.dt_name = dt_name;
		this.name = name;
		this.amount = amount;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String  getDt_name() {
		return dt_name;
	}
	public void setDt_name(String dt_name) {
		this.dt_name = dt_name;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public LocalDateTime getBoughtTime() {
        return boughtTime;
    }

    public void setBoughtTime(LocalDateTime boughtTime) {
        this.boughtTime = boughtTime;
    }

    // Define a method annotated with @PrePersist to set boughtTime before saving to database
    @PrePersist
    public void setBoughtTimeBeforePersist() {
        this.boughtTime = LocalDateTime.now();
    }
	
	

}
