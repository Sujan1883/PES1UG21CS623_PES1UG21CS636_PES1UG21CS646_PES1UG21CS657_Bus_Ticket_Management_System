package com.code.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.rest.entity.Route;
import com.code.rest.repository.RouteRepository;
import com.code.rest.service.RouteService;

@Service
public class RouteServiceimpl implements RouteService {
	
	@Autowired
	RouteRepository rep;
	public List<Route> getAll(){
		return rep.findAll();
		
	}
	
	

}
