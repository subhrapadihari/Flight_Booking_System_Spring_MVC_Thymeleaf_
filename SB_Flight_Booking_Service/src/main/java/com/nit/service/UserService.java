package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User registerUser(User user) {
		
		user.setPassword(
				passwordEncoder.encode(user.getPassword())
				);
		 user.setRole("USER");
		return userRepository.save(user);
	}
		
	
	}
