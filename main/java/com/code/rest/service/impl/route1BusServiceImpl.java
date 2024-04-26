package com.code.rest.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.code.rest.entity.route1Bus;
import com.code.rest.repository.route1BusRepository;
import com.code.rest.service.BusService;

@Service
public class route1BusServiceImpl implements BusService {

    private final route1BusRepository repository;

    
    public route1BusServiceImpl(route1BusRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<route1Bus> getBus() {
        return repository.findAll();
    }
}
