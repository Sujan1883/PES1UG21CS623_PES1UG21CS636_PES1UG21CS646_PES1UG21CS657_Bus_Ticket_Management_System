package com.code.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.rest.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmailAndPassword(String email, String password);

}
