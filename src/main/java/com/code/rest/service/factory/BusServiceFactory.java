package com.code.rest.service.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.rest.repository.route1BusRepository;
import com.code.rest.repository.route2BusRepository;
import com.code.rest.service.BusService;
import com.code.rest.service.impl.route1BusServiceImpl;
import com.code.rest.service.impl.route2BusServiceImpl;

public class BusServiceFactory {

    private final route1BusRepository r1Repository;
    private final route2BusRepository r2Repository;

    @Autowired
    public BusServiceFactory(route1BusRepository r1Repository, route2BusRepository r2Repository) {
        this.r1Repository = r1Repository;
        this.r2Repository = r2Repository;
    }

    
	public BusService getService(String routeType) {
        switch (routeType) {
            case "r1":
                return new route1BusServiceImpl(r1Repository);
            case "r2":
                return new route2BusServiceImpl(r2Repository);
            default:
                throw new IllegalArgumentException("Invalid route type");
        }
    }
}
