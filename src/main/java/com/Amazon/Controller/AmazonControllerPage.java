package com.Amazon.Controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Amazon.Model.CartItem;
import com.Amazon.Model.CategoryResponse;
import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.ItemResponse;
import com.Amazon.Model.UserDetails;
import com.Amazon.Service.CartService;
import com.Amazon.Service.CategoryService;
import com.Amazon.Service.ItemService;
import com.Amazon.Service.ProductDetailService;
import com.Amazon.Service.UserService;


@RestController
@Component
public class AmazonControllerPage {

	Logger logger = LoggerFactory.getLogger(AmazonControllerPage.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ProductDetailService productService;
	
	@Autowired
	CartService cartService;
	
	@PostConstruct
	public void init(){
		logger.info("Controller: Entered POstConstruct Block");
		userService.insertUser();
		productService.insertProductDetails();
	}

	 	@GetMapping("/getAllCategory")
	    public CategoryResponse  getAllCategoryList() {
	 		logger.info("Controller: Entered getAllCategoryList()");
	        return categoryService.getAllCategory();
	    }
	 	
	 	 @GetMapping("/getCategoryItems")
	     public ItemResponse getSelectedCategoryItems(@RequestParam(name = "categoryId") String categoryId) {
	 		logger.info("Controller: Entered getSelectedCategoryItems()");
	         return itemService.getCategoryItemList(categoryId);
	     }
	 	 
	 	@PostMapping("/login")
	    public CommonResponse userLogin(@RequestBody UserDetails userObject) {
	 		logger.info("Controller: Entered UserLogin()");
	 		return userService.loginUser(userObject);
	    }
	 	
	 	@GetMapping(value="/addItems")
	 	public CommonResponse addItemsToCart(@RequestParam List<String> itemIdList,@RequestParam(name = "userName") String name) {
	 		logger.info("Controller: Entered addItemsToCart()");
	        return cartService.addItems(itemIdList,name);
	    }
	 	
	 	@DeleteMapping(path = "/deleteItem")
	    public CommonResponse deleteItem(@RequestParam(name = "itemId") String itemId,@RequestParam(name = "userName") String name) {
	 		logger.info("Controller: Entered deleteItem()");
	        return cartService.removeIteminCart(itemId,name);
	    } 
	 	
	 	@GetMapping("/getCartItem")
	    public ItemResponse  getCartItem(@RequestParam(name = "userName") String name) {
	 		logger.info("Controller: Entered getCartItem()");
	        return cartService.getAllCartItem(name);
	    }
}
