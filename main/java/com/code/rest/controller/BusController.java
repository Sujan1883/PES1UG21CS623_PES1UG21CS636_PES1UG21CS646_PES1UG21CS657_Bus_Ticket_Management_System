package com.code.rest.controller;

//import java.awt.PageAttributes.MediaType;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.rest.entity.Login;
// import com.code.rest.entity.Recipe;
import com.code.rest.entity.Student;
import com.code.rest.entity.Users;
// import com.code.rest.repository.RecipeRepository;
import com.code.rest.repository.StudentRepository;
import com.code.rest.repository.UsersRepository;
import com.code.rest.service.AdminService;
import com.code.rest.service.Userservice;

import jakarta.annotation.PostConstruct;

@Controller
public class BusController {
	@Autowired
	Userservice user;
	
	@Autowired
	AdminService ad;
//	@Autowired
//	StudentRepository repo;
//	@Autowired
//	UsersRepository usr;

  
//	@GetMapping("/students")
//	public List<Student>getAll(){
//		List<Student> students =repo.findAll();
//		
//		
//		return students;
//	}
	@GetMapping("/users")
	public List<Users>getAl(){
//		List<Users> u =usr.findAll();
//		
//		
//		return u;
		return user.getAll();
	}
	
	@GetMapping("/login/{flag}")
	public String loginPage(@PathVariable boolean flag, Model model) {
	    model.addAttribute("flag", flag);
	    return "login";
	}
	@GetMapping("/signup")
	public String signupPage() {
	    
	    return "signup";
	}
	
	
	@PostMapping("/user/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String addUser(Users u,Model model) {
		
		user.createUser(u);
		System.out.println("hello");
		model.addAttribute("mail", u.getEmail());
		
		return "user";
	}
	@PostMapping( value= "/user/login/{flag}")
	public String checkUser(Login a,Model model,@PathVariable boolean flag ) {
		if (flag) {
		if ( user.check(a)) {
			model.addAttribute("mail" ,a.getEmail());
			return "user";
			
		}
		
		model.addAttribute("flag", flag);
		return "login";
		}
		else {
			if ( ad.check(a)) {
				
				return "ad";
			}
			System.out.println("hello"+a.getEmail()+a.getPassword());
			model.addAttribute("flag", flag);
			return "login";
			
			
		}
			
		}
	
//	@GetMapping("/student/{id}")
//	public Student get(@PathVariable int id) {
//		
//		Student st=repo.findById(id).get();
//		return st;
//		
//	}
//	@PostMapping("/student/add")
//	@ResponseStatus(code=HttpStatus.CREATED)
//	public void addStudent(@RequestBody Student student) {
//		repo.save(student);
//	}
	
	
//	@PutMapping("/student/update/{id}")
//	public Student updateStudent(@PathVariable int id) {
//		Student st=repo.findById(id).get();
//		
//		st.setName("poonam");
//		st.setPercent(91);
//		repo.save(st);
//		return st;
//		
//		
//	}
//	@DeleteMapping("/student/delete/{id}")
//	public void rem(@PathVariable int id) {
//		Student st=repo.findById(id).get();
//		repo.delete(st);
//	}
	
}
