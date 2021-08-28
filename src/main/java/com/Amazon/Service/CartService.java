package com.Amazon.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amazon.Model.CartItem;
import com.Amazon.Model.CategoryResponse;
import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.ItemResponse;
import com.Amazon.Repository.CartRepository;
import com.Amazon.Repository.CategoryRepo;
import com.Amazon.Repository.ItemRepo;

@Service
public class CartService {

	Logger logger = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	CartRepository cartRepo;
	
	public CommonResponse addItems(List<String> itemIdList,String userName) {
		logger.info("Service:ItemService: Entered addItems()");
		CommonResponse response = cartRepo.insertItemstoCart(itemIdList,userName);
        return response;
	}
	public CommonResponse removeIteminCart(String itemId,String userName) {
		return cartRepo.deleteIteminCart(itemId,userName);
	}
	public ItemResponse getAllCartItem(String userName) {
		logger.info("Service:ItemService: Entered getAllCategory()");
		System.out.println("Entered service getCategory()");
		return cartRepo.getAddedItem(userName);
	}
}
