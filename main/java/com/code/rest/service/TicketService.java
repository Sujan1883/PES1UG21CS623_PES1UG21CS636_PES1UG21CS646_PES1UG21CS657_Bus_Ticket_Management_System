package com.code.rest.service;

import java.util.List;

import com.code.rest.entity.Ticket;

public interface TicketService {
	public Boolean Valid(String s);
	public List <Ticket> get(String S);
	public void add(String from,String to ,String name,double fare);
	public Boolean tic(Long a);
	public void inv(Long a);
	
}
