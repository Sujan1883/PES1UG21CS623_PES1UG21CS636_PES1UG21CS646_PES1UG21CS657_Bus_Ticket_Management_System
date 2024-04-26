package com.code.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.code.rest.entity.route2Stops;


public interface route2StopsRepository extends JpaRepository<route2Stops, Long>{

	route2Stops findByName(String s);
	

}
