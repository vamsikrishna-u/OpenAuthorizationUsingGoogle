package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Students;
import com.example.demo.model.Users;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.MyUserService;


@RestController
public class UserControoler {
	
	@Autowired
	MyUserService myuserService;
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/register")
	public String register(@RequestBody Users user) {
		myuserService.addUser(user);
		
		return"user added";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println(user);
		
		return myuserService.verify(user);
		
	}
	@GetMapping("/fetch")
	public List<Students> fetchData() {
		
		ArrayList<Students>arrayList=new ArrayList<>();
		Students student=new Students(1,"vamsi",100);
		Students student2=new Students(2,"ravi",90);
		arrayList.add(student);
		arrayList.add(student2);
		return arrayList;

		
	
	
		
	}
	
	

}
