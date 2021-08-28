package com.Amazon.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.UserAddress;
import com.Amazon.Model.UserDetails;
@Component
public class CommonRepo{

	Logger logger = LoggerFactory.getLogger(CommonRepo.class);
	
	 @Autowired
	    private SessionFactory sessionFactory;

	    public Session getSession() {
	    	logger.info("Repository::CommonRepo::Entered getSession ");
	        Session session = sessionFactory.getCurrentSession();
	        if (session == null) {
	            session = sessionFactory.openSession();
	        }
	        return session;
	    }

	    public CommonResponse setSuccess(CommonResponse response) {
	    	logger.info("Repository::CommonRepo::Entered setSuccess ");
	        response.setStatusCode("200");
	        response.setStatusMessage("Transaction successfull");
	        return response;
	    }
	    
	    public CommonResponse setFailure(CommonResponse response, String message) {
	    	logger.info("Repository::CommonRepo::Entered setFailure with message");
	        response.setStatusCode("401");
	        response.setStatusMessage(message);
	        return response;
	    }

	    public CommonResponse setFailure(CommonResponse response, Exception exception) {
	    	logger.info("Repository::CommonRepo::Entered setFailure with exception");
	        response.setStatusCode("400");
	        response.setStatusMessage("Transaction failed" + exception.getMessage());
	        return response;
	    }
	
}
