package com.Amazon.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.CategoryList;
import com.Amazon.Model.CategoryResponse;

@Component
@Repository
@Transactional
public class CategoryRepo extends CommonRepo{
	
	Logger logger = LoggerFactory.getLogger(CategoryRepo.class);

	 public CategoryResponse getCategoryList(){
		 logger.info("Repository:CategoryRepo: Entered getCategoryList()");
    	 CategoryResponse response = new CategoryResponse();
         try {
             Session session = getSession();
             Query query = session.createQuery("from CategoryList");
             List<CategoryList> myCategoryList = query.getResultList();
             response.setCategoryList(myCategoryList);
             logger.info("Repository:CategoryRepo: getCategoryList() retrieved successfully");
             setSuccess(response);
         } catch (Exception exception) {
        	 logger.error("Repository:CategoryRepo: Exception in getCategoryList() "+exception.getStackTrace());
             setFailure(response, exception);
         }
         logger.info("Repository:CategoryRepo: Success response for getCategoryList()"+response);
         return response;
         
    }
	
}
