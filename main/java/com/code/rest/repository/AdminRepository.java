package com.code.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.rest.entity.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByEmailAndPassword(String email, String password);

}
