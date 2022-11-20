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

import com.operation.model.User;
import com.operation.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@GetMapping("/Successfully")
	public String adminsuccess() {
		return "Successfully Login";
	}

	@GetMapping("/403")
	public String error() {
		return "Access Denied";
	}
	
	@GetMapping("/admin/dashboard")
	public String admindashboard() {
		return "Admin Dashboard";
	}

	@GetMapping("/user/dashboard")
	public String userdashboard() {
		return "User Dashboard";
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

	@PostMapping("/register") // To add user
	public User user(@RequestParam("username") String username, @RequestParam("roles") String roles,
			@RequestParam("password") String password) {
		User user = new User();
		user.setUsername(username);
		user.setRoles(roles);
		user.setPassword(encoder.encode(password));
		return repo.save(user);

	}
}
