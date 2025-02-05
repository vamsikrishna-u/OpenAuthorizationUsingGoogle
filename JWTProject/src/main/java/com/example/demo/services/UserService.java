package com.example.demo.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPrincipal;
import com.example.demo.model.Users;
import com.example.demo.repos.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=userRepo.findByUserName(username);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
