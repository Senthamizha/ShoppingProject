package com.Amazon.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.CartItem;
import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.ItemList;
import com.Amazon.Model.ItemResponse;

@Repository
@Transactional
public class CartRepository extends CommonRepo{

	Logger logger = LoggerFactory.getLogger(CartRepository.class);
	
	public CommonResponse insertItemstoCart(List<String> itemIdList,String userName) {
		CommonResponse response = new CommonResponse();
		try {
			logger.info("Repository:CartRepo: Entered insertItemstoCart()");
			Session session = getSession();
			for(String item:itemIdList) {
				logger.info("Repository:CartRepo: insertItemstoCart() username= "+userName+"Item= "+item);
				CartItem cartItem = new CartItem(userName,item);
				session.save(cartItem);
				logger.info("Repository:CartRepo: insertItemstoCart() Items saved in cart successfully");
			}
			response.setStatusCode("200");
	        response.setStatusMessage("Item added in cart successfull");
		}catch (DataIntegrityViolationException e) {
			logger.error("Repository:CartRepo: Exception in getAddedItem() Item already added in cart ");
			response.setStatusCode("409");
	        response.setStatusMessage("Item Already Added in cart");
	        return response;
		}catch (Exception exception) {
	       	 logger.error("Repository:CartRepo: Exception in getAddedItem() "+exception.getStackTrace());
	       	response.setStatusCode("500");
	        response.setStatusMessage("Please send proper ID");
	        return response;
	        }
		
		return response;
	}
	
	public CommonResponse deleteIteminCart(String itemId,String userName) {
		CommonResponse response = new CommonResponse();
		try {
			Session session = getSession();
			Query query = session.createQuery("delete from CartItem where itemId =:itemId and userName=:userName").setParameter("itemId", itemId).setParameter("userName", userName);
			
			if((query.executeUpdate() == 1)) {
				logger.info("Repository:CartRepo: deleteIteminCart() Items deleted in cart successfully");
				response.setStatusCode("200");
		        response.setStatusMessage("Item removed in cart successfully");
				return response;
			}
			else {
				logger.info("Repository:CartRepo: deleteIteminCart() Items not deleted in cart");
				response.setStatusCode("400");
		        response.setStatusMessage("Item not in cart");
				return response;
			}
		}catch (Exception exception) {
	       	 logger.error("Repository:CartRepo: Exception in getAddedItem() "+exception.getStackTrace());
	       	response.setStatusCode("500");
	        response.setStatusMessage("Exception occured "+exception);
	        return response;
	        }
	}
	
	public ItemResponse getAddedItem(String userName){
		logger.info("Repository:CartRepository: Entered getAddedItem()");
    	ItemResponse response = new ItemResponse();
        try {
            Session session = getSession();
            Query query = session.createQuery("select item from ItemList item,CartItem cart where item.itemId=cart.itemId and cart.userName=:userName").setParameter("userName",userName);
            List<ItemList> myItemList = query.getResultList();
            response.setItemList(myItemList);
            logger.info("Repository:CartRepository: getAddedItem() retrieved successfully");
            setSuccess(response);
        } catch (Exception exception) {
       	 logger.error("Repository:CartRepository: Exception in getAddedItem()");
            setFailure(response, exception);
        }
        logger.info("Repository:CartRepository: success response for getAddedItem()"+response);
        return response;
	}
	
	public CommonResponse itemsCount(String userName) {
		logger.info("Repository:CartRepository: Entered itemsCount()");
		CommonResponse response = new CommonResponse();
		try {
			Session session = getSession();
            int result= (int)((long)session.createQuery("select count(p) from CartItem p where p.userName = :userName")
                    .setParameter("userName", userName).uniqueResult());
            logger.info("Repository:CartRepository: getAddedItem() Total Items Count= "+result);
            logger.info("Repository:CartRepository: getAddedItem() retrieved successfully");
            setSuccess(response);
		} catch (Exception exception) {
	       	 logger.error("Repository:CartRepository: Exception in itemsCount()");
	            setFailure(response, exception);
	        }
		return response;
	}
	
}
