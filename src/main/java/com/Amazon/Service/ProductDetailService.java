package com.Amazon.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amazon.Repository.ProductDetailRepo;

@Component
public class ProductDetailService {
	Logger logger = LoggerFactory.getLogger(ProductDetailService.class);
	@Autowired
	ProductDetailRepo productRepo;
	
	public void insertProductDetails() {
		logger.info("Service:ProductDetailService: Entered insertProductDetails()");
		productRepo.saveAllProducts();
	}
	
}
