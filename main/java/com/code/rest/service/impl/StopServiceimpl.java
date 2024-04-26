package com.code.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.rest.entity.route1Stops;
import com.code.rest.entity.route2Stops;
import com.code.rest.repository.route1StopsRepository;
import com.code.rest.repository.route2StopsRepository;
import com.code.rest.service.StopService;

@Service
public class StopServiceimpl implements StopService {
	
	@Autowired
	route1StopsRepository rep1;
	
	@Autowired
	route2StopsRepository rep2;
	
	public List<route1Stops> getroute1Stops(){
		return rep1.findAll();
	}
	public List<route2Stops> getroute2Stops(){
		return rep2.findAll();
	}
	
	public List<String> getr1(){
		List<String>StopNames = new ArrayList<>();
		List<route1Stops> g = rep1.findAll();
		for (route1Stops route1Stops : g) {
	        StopNames.add(route1Stops.getName());
	    }
		return StopNames;
		
	}
	public List<String> getr2() {
	    List<String> StopNames = new ArrayList<>();
	    List<route2Stops> route2Stopss = rep2.findAll();
	    for (route2Stops route2Stops : route2Stopss) {
	        StopNames.add(route2Stops.getName());
	    }
	    return StopNames;
	}
	public List<Long> getId(String s) {
	    List<Long> result = new ArrayList<>();

	    // Search for route1Stops by name
	    route1Stops route1Stops = rep1.findByName(s);
	    if (route1Stops != null) {
	        result.add(route1Stops.getSid());
	        result.add((long) 0);
	    } else {
	        // If not found in route1Stops, search in route2Stops
	        route2Stops route2Stops = rep2.findByName(s);
	        if (route2Stops != null) {
	            result.add(route2Stops.getSid());
	            result.add((long) 1);
	        } else {
	            result.add(null); // If Stop not found, add null to indicate no match
	            result.add((long) -1);   // Add -1 to indicate no match from route1Stops or route2Stops
	        }
	    }

	    return result;
	}

	
	}
	


