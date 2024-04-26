package com.code.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.rest.entity.route1Stops;


public interface route1StopsRepository extends JpaRepository<route1Stops, Long>{

	route1Stops findByName(String s);
	

}
