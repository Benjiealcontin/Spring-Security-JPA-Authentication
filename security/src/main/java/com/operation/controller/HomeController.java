package com.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.operation.Service.Services;
import com.operation.model.User;
import com.operation.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private Services service;
	
	 @RequestMapping("/")
	    public ModelAndView home() {
	        return new ModelAndView("home");
	    }
	 	
	    @PreAuthorize("hasRole('USER')")
	    @GetMapping("/user")
	    public String user() {
	        return "Hello, User!";
	    }

	    @PreAuthorize("hasRole('ADMIN')")
	    @GetMapping("/admin")
	    public String admin() {
	        return "Hello, Admin!";
	    }
}
