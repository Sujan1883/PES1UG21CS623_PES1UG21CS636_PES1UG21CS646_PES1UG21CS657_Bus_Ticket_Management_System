package com.code.rest.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.rest.entity.Ticket;
import com.code.rest.repository.TicketRepository;
import com.code.rest.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired 
	TicketRepository rep;
	public Boolean Valid(String s) {
	    List<Ticket> tickets = rep.findByName(s);
	    
	    if (tickets != null && !tickets.isEmpty()) {
	    	
	        LocalDateTime currentTime = LocalDateTime.now();
	        for (Ticket ticket : tickets) {
	        	System.out.println("ticket there"+ticket.getStatus());
	            if (ticket.getStatus()) {
	                LocalDateTime boughtTime = ticket.getBoughtTime();
	                long hoursDifference = ChronoUnit.HOURS.between(boughtTime, currentTime);
	                System.out.println(hoursDifference);
	                if (hoursDifference > 24) {
	                    // Set status to false if bought more than 24 hours ago
	                    ticket.setStatus(false);
	                    rep.save(ticket);
	                } else {
	                    // Return false if there is a ticket bought within 24 hours and has status true
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
	public List <Ticket> get(String s){
		 List <Ticket > t=rep.findByName(s);
		 
		 return t;
	}
	public void add(String from,String to ,String name,double fare) {
		Ticket ticket = new Ticket();
	    
	    // Set the properties of the ticket object
	    ticket.setSt_name(from);
	    ticket.setDt_name(to);
	    ticket.setname(name);
	    ticket.setAmount(fare);
	    
	    // Set the boughtTime using @PrePersist method
	    ticket.setBoughtTimeBeforePersist();
	    
	    // Save the ticket object using TicketRepository
	    rep.save(ticket);
		
	}
	
	public Boolean tic(Long a) {
	    // Find the ticket by its PNR
	    Ticket ticket = rep.findByPnr(a);
	    
	    // Check if the ticket exists and its status is true
	    if (ticket != null && ticket.getStatus()) {
	        return true;  // Ticket with the given PNR exists and its status is true
	    } else {
	        return false; // Either ticket with the given PNR doesn't exist or its status is false
	    }
	}
	public void inv(Long a) {
	    // Find the ticket by its PNR
	    Ticket ticket = rep.findByPnr(a);
	    
	    // Check if the ticket exists
	    if (ticket != null) {
	        // Set the status of the ticket to false
	        ticket.setStatus(false);
	        
	        // Save the updated ticket in the database
	        rep.save(ticket);
	    } 
	}
}
