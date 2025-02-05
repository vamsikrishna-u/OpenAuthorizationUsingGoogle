package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPrincipal;
import com.example.demo.model.Users;
import com.example.demo.repos.UserRepo;

@Service
public class MyUserService {
	
	

	@Autowired
	UserRepo userRepo;
	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	public void addUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		
		System.out.println("password method executing");
	}



	public String verify(Users user) {
		
	Authentication authentication=authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		if(authentication.isAuthenticated()) 
			return jwtService.generateToken(user.getUserName());
		return "false";
	}


}
