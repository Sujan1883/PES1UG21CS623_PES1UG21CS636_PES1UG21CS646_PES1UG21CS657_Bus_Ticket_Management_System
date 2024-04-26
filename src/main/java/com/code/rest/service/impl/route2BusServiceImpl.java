package com.code.rest.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.code.rest.entity.route2Bus;
import com.code.rest.repository.route2BusRepository;
import com.code.rest.service.BusService;

@Service
public class route2BusServiceImpl implements BusService {

    private final route2BusRepository repository;

    public route2BusServiceImpl(route2BusRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<route2Bus> getBus() {
        return repository.findAll();
    }
}