package com.Amazon.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amazon.Model.CategoryResponse;
import com.Amazon.Repository.CategoryRepo;

@Component
public class CategoryService {
	Logger logger = LoggerFactory.getLogger(CategoryService.class);
	@Autowired
	CategoryRepo categoryRepo;

	public CategoryResponse getAllCategory() {
		logger.info("Service:CategoryService: Entered getAllCategory()");
		System.out.println("Entered service getCategory()");
		CategoryResponse response = categoryRepo.getCategoryList();
		logger.info("Service:CategoryService: success response in getAllCategory()"+response);
		return response;
	}
	
}
