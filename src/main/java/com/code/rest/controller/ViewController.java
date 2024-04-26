package com.code.rest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.rest.entity.route1Bus;
import com.code.rest.entity.route1Stops;
import com.code.rest.entity.Bus;
import com.code.rest.entity.route2Bus;
import com.code.rest.entity.route2Stops;
import com.code.rest.entity.Route;
import com.code.rest.entity.Stop;
import com.code.rest.repository.route1BusRepository;
import com.code.rest.repository.route1StopsRepository;
import com.code.rest.repository.route2BusRepository;
import com.code.rest.service.BusService;
import com.code.rest.service.RouteService;
import com.code.rest.service.StopService;
import com.code.rest.service.TicketService;
import com.code.rest.service.factory.BusServiceFactory;
import com.code.rest.service.factory.StopFacade;

@Controller
@RequestMapping("/view/")
public class ViewController {
	
	@Autowired
	RouteService rot;

	
	@Autowired
	StopService st;
	
	@Autowired
	route1BusRepository r1;
	
	@Autowired
	route2BusRepository r2;
	
	@Autowired
	StopFacade s;
	
	@Autowired 
	TicketService ti;
	
	@GetMapping("/1")
	public String getRoutes(Model model) {
		List<String> routeNames = new ArrayList<>();
		List<Route> routes = rot.getAll();
		for (Route route : routes) {
			routeNames.add(route.getName());
		}
		model.addAttribute("routes", routeNames);
		return "routes";
	}
	@GetMapping("/2")
	public String getStop(Model model) {
		List<String> StopNames=s.getAllStops();
		model.addAttribute("routes", StopNames);
		return "routes";
	}
	
	@GetMapping("/3")
	public String getBus(Model model) {
		List<Long> busNames = new ArrayList<>();

		// Use the factory method to get BusService instances
		BusServiceFactory serviceFactory = new BusServiceFactory(r1,r2);
		BusService r1BusService = serviceFactory.getService("r1");
		List<? extends Bus> bus1 = r1BusService.getBus();

		BusService r2BusService = serviceFactory.getService("r2");
		List<? extends Bus> bus2 = r2BusService.getBus();

		for (Bus route : bus1) {
		    busNames.add(route.getMid());
		}
		for (Bus route : bus2) {
		    busNames.add(route.getMid());
		}

		model.addAttribute("routes", busNames);
		return "routes";
	}
	@GetMapping("/4")
	public String verify(Model model) {
		model.addAttribute("msg", "");
		return "verify";
	}
	@GetMapping("/5")
	public String v(Model model) {
		model.addAttribute("msg", "");
		return "invalid";
	}
//	@GetMapping("/5")
//	public String invalidate(Model model) {
//		return "invalid";
//	}
//	
	@PostMapping("/verify")
	public String verifyTicket(Model model, @RequestParam("id") Long id) {
	    if (ti.tic(id)) {
	        model.addAttribute("msg", "Valid ticket");
	    } else {
	        model.addAttribute("msg", "Invalid ticket");
	    }
	    return "verify";
	}
	@PostMapping("/invalid")
	public String invalidateTicket(Model model, @RequestParam("id") Long id) {
		ti.inv(id);
	    
	    return "ad";
	}
}
