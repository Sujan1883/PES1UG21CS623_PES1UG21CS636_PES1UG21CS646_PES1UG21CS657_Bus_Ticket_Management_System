package com.code.rest.service.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.code.rest.entity.Stop;

import com.code.rest.service.StopService;

@Service
public class StopFacadeimpl implements StopFacade {
    
    @Autowired
    private StopService StopService;

    @Override
    public List<String> getAllStops() {
        List<String> allStops = new ArrayList<>();
        allStops.addAll(StopService.getr1());
        allStops.addAll(StopService.getr2());
        return allStops;
    }
}
