package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.entity.User;
import com.nit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String showResisterPage(Model model) {	
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user) {
		userService.registerUser(user);
		return "redirect:/login";
	}

}
