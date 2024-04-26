package com.code.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.rest.entity.route1Stops;
import com.code.rest.entity.route2Stops;
import com.code.rest.entity.Sample;
import com.code.rest.entity.Ticket;
import com.code.rest.service.StopService;
import com.code.rest.service.TicketService;
import com.code.rest.strategy.FareCalculationContext;
import com.code.rest.strategy.FareCalculationStrategy;
import com.code.rest.strategy.FareStrategySelector;
import java.time.LocalTime;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    TicketService tick;
    @Autowired
    StopService st;
    private final FareStrategySelector strategySelector;

    public UserController(FareStrategySelector strategySelector) {
      this.strategySelector = strategySelector;
    }

    
    @GetMapping("/1/{mail}")
    public String book(@PathVariable String mail, Model model) {
        System.out.println("hello working");
        model.addAttribute("mail", mail);
        if (tick.Valid(mail)) {
        	List<String> StopNames = new ArrayList<>();
    		List<route1Stops> Stop1 = st.getroute1Stops();
    		for (route1Stops route : Stop1) {
    			StopNames.add(route.getName());
    		}
    		List<route2Stops> Stop2 = st.getroute2Stops();
    		for (route2Stops route : Stop2) {
    			StopNames.add(route.getName());
    		}
    		model.addAttribute("Stop", StopNames);
            return "ticket"; // Redirect to success page if ticket is valid
        } else {
            return "user"; // Redirect to error page if ticket is not valid
        }
    }
    
//    @PostMapping("/book/{mail}")
//    public String movetopay(@PathVariable String mail,Model m,@RequestBody Sample s) {
//    	
//    	
//    	m.addAttribute("mail", mail);
//    	m.addAttribute("from", s.getFrom());
//    	m.addAttribute("to", s.getTo());
//    	System.out.println(s.getFrom()+s.getTo());
//    	return "rec";
//    	
//    }
    @PostMapping("/book/{mail}")
    public String handleFormSubmission(@PathVariable String mail, Sample s, BindingResult result, Model model) {
    	System.out.println(s.getFrom()+s.getTo());
    	
    	List<Long> result1 = new ArrayList<>();
    	List<Long> result2 = new ArrayList<>();
    	result1=st.getId(s.getFrom());
    	result2=st.getId(s.getTo());
    	int dist;
    	double fare;
    	if (result1.get(1).equals(result2.get(1))) {
    	    dist = (int) Math.abs(result1.get(0) - result2.get(0));
    	} else {
    	    dist = (int) (Math.abs(result1.get(0) - 5) + Math.abs(result2.get(0) - 5));
    	}
        
    	LocalTime currentTime = LocalTime.now();
        LocalTime evening3 = LocalTime.of(15, 0); // 3:00 PM
        LocalTime evening8 = LocalTime.of(20, 0);
        Boolean ispeak;
        if (currentTime.isAfter(evening3) && currentTime.isBefore(evening8)) {
            ispeak = true;
        } else {
            ispeak = false;
        }
    	FareCalculationStrategy strategy = strategySelector.selectStrategy(ispeak);
        FareCalculationContext context = new FareCalculationContext(strategy);
        fare=context.calculateFare(dist);
        System.out.println(fare);
        
        model.addAttribute("mail", mail);
        model.addAttribute("from",s.getFrom());
        model.addAttribute("to",s.getTo());
        model.addAttribute("fare",fare);
        
        
    	
    	
    	return "pay";
    	
        // Your logic to handle the form submission goes here
    	
    	
    	
    }
    
    @GetMapping("/2/{mail}")
    public String viewTickets(@PathVariable String mail, Model model) {
    	List<Ticket> t= tick.get(mail);
    	
    	
    	model.addAttribute("mail", mail);
    	model.addAttribute("tickets", t);
    	return "all";

    	
    	
    }
    @PostMapping("/paid/{mail}/{fare}")
    public String handleFormSubmission(@PathVariable String mail,@PathVariable String fare, Sample s, BindingResult result, Model model) {
    	System.out.println(s.getFrom()+s.getTo());
    	tick.add(s.getFrom(), s.getTo(), mail, Double.parseDouble(fare));

    	List<Ticket> t= tick.get(mail);
    	
    	
    	model.addAttribute("mail", mail);
    	model.addAttribute("tickets", t);
    	return "all";
    }


}
