package com.Amazon.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.UserAddress;
import com.Amazon.Model.UserDetails;
import com.Amazon.Repository.UserRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepository userRepo;
	
	public void insertUser(){
		logger.info("Service:UserService: Entered insertUser()");
		userRepo.saveUser();
	}
	public CommonResponse loginUser(UserDetails userObject) {
				logger.info("Service:UserService: Entered loginUser()");
                return userRepo.getUserAddress(userObject);
    }
	public CommonResponse signUpUserDetails(UserDetails user,UserAddress address) {
		logger.info("Service:UserService: Entered signUpUserDetails()");
				return userRepo.signUpUser(user,address);
	}
}
