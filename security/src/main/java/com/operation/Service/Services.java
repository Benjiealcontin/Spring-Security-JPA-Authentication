package com.operation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operation.model.User;
import com.operation.repository.UserRepository;

@Service
public class Services {

	@Autowired
	private UserRepository repo;
	
	public User adduser(User user) {
		return repo.save(user);
		
	}
}
