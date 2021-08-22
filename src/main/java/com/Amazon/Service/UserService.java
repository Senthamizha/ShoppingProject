package com.Amazon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amazon.Repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	@Autowired
	UserRepository userRepo;
	public void insertUser(){
		System.out.println("Entered service");
		userRepo.saveUser();
	}
}
