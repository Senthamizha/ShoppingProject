package com.Amazon.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Amazon.Model.ItemResponse;
import com.Amazon.Repository.ItemRepo;
@Component
@Service
public class ItemService {
	Logger logger = LoggerFactory.getLogger(ItemService.class);
	@Autowired
	ItemRepo itemRepo;

	public ItemResponse getCategoryItemList(String categoryId) {
		logger.info("Service:ItemService: Entered getCategoryItemList()");
		ItemResponse response = itemRepo.getCategoryItemList(categoryId);
        return response;
    }
	
	
}
