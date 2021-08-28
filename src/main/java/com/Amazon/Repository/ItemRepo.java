package com.Amazon.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.CartItem;
import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.ItemList;
import com.Amazon.Model.ItemResponse;

@Component
@Transactional
@Repository
public class ItemRepo extends CommonRepo{
	
	Logger logger = LoggerFactory.getLogger(ItemRepo.class);
	
	public ItemResponse getCategoryItemList(String categoryId) {
		 logger.info("Repository:ItemRepo: Entered getCategoryItemList()");
    	ItemResponse response = new ItemResponse();
        try {
            Session session = getSession();
            Query query = session.createQuery("from ItemList where categoryId=" +categoryId);
            List<ItemList> myItemList = query.getResultList();
            response.setItemList(myItemList);
            logger.info("Repository:ItemRepo: getCategoryItemList() retrieved sussfully");
            setSuccess(response);
        } catch (Exception exception) {
       	 logger.error("Repository:IremRepo: Exception in getCategoryItemList()");
            setFailure(response, exception);
        }
        logger.info("Repository:ItemRepo: success response for getCategoryItemList()"+response);
        return response;
    }
	
	
}
