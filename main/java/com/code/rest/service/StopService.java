package com.code.rest.service;

import java.util.List;

import com.code.rest.entity.route1Stops;
import com.code.rest.entity.route2Stops;

public interface StopService {
	public List<route1Stops> getroute1Stops();
	public List<route2Stops> getroute2Stops();
	
	public List <String> getr1();
	public List<String> getr2();
	
	public List<Long> getId(String s);
	
}
