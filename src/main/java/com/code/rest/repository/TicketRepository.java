package com.code.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.rest.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long>{

	List<Ticket> findByName(String s);

	Ticket findByPnr(Long a);
	

}
