package com.code.rest.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pay_id;
	protected long pnr;
	private String type;
	public Payment(long pay_id, long pnr, String type) {
		super();
		this.pay_id = pay_id;
		this.pnr = pnr;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Payment [pay_id=" + pay_id + ", pnr=" + pnr + ", type=" + type + "]";
	} 
	
	
	 
	 
	 
	 
}
