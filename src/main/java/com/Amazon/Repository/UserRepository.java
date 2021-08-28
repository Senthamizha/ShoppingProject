package com.Amazon.Repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.AddressResponse;
import com.Amazon.Model.CommonResponse;
import com.Amazon.Model.UserAddress;
import com.Amazon.Model.UserDetails;

@Repository
@Transactional
public class UserRepository extends CommonRepo{
	
		Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	public void saveUser() {
		logger.info("Repository:UserRepository Entered saveUser()");
		Session session1 = getSession();
		UserDetails user1 = new UserDetails("admin","password");
		user1.setUserName("admin");
		user1 = (UserDetails) session1.find(UserDetails.class, user1.getUserName());
	    if(user1!=null){
	    	logger.info("Repository:UserRepository UserDetails Already Stored");
	    }else{
	    	UserDetails user = new UserDetails("admin","password");
	    	UserAddress address = new UserAddress(32,"Kamaraj Street","Chennai","TamilNadu",600900,908767898l); 
			//address.setUserDetails(user);
	    	session1.save(user);
	    	session1.save(address);
	    	logger.info("Repository:UserRepository UserDetails Stored Successfully");
	    }
	}
        public CommonResponse getUserAddress(UserDetails userObject) {
        	logger.info("Repository:UserRepository Entered getUserAddress()");
        	 String name = userObject.getUserName();
             String password = userObject.getPassword();
        	AddressResponse response = new AddressResponse();
        	try {
        	if(name.equals("admin") && password.equals("password")) {
        		Session session = getSession();
        		UserAddress address = (UserAddress) session.find(UserAddress.class, name);
        		response.setAddress(address);
        		setSuccess(response);
        	}else {
        		logger.info("Repository:UserRepository Entered getUserAddress() Invalid Credentials");
        		setFailure(response, "Invalid Credentials");
        	}
        	}catch (Exception exception) {
        		logger.error("Repository:UserRepository Exception in getUserAddress()");
                setFailure(response, exception);
            }
        	logger.info("Repository:UserRepository success response in getUserAddress()"+response);
        	return response;
        }
        
	    
	}

