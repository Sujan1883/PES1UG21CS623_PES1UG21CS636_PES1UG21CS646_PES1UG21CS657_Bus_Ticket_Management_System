package com.code.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.rest.entity.Login;
import com.code.rest.entity.Users;
import com.code.rest.repository.UsersRepository;
import com.code.rest.service.Userservice;


@Service
public class UserServiceimpl  implements Userservice{
	
	@Autowired
	UsersRepository rep;
//	public UserServiceimpl(UsersRepository rep) {
//		this.rep=rep;
//	}
	public void createUser(Users u) {
		rep.save(u);
		
	}
	public List<Users> getAll(){
		return rep.findAll();
	}
	public Boolean check(Login loginInfo) {

		Users user = rep.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());
        return user != null;

	}
    
}
