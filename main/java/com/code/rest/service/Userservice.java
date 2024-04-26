package com.code.rest.service;

import java.util.List;

import com.code.rest.entity.Login;
import com.code.rest.entity.Users;

public interface Userservice {
	public void createUser(Users u);
	public List<Users> getAll();
	public Boolean check(Login a);
}
