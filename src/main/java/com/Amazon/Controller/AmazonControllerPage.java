package com.Amazon.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Amazon.Service.UserService;


@RestController
@Component
public class AmazonControllerPage {

	@Autowired
	UserService userService;
	
	@PostConstruct
	public void init(){
		userService.insertUser();
	}
	
	@RequestMapping(path="/hello")
	public Integer avalue(){
		System.out.println("Entered Hello");
		return 500;
	}
	
}
