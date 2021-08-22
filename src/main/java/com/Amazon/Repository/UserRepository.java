package com.Amazon.Repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.UserAddress;
import com.Amazon.Model.UserDetails;

@Repository
@Transactional
public class UserRepository implements UserRepositoryInterface{
	

	@Autowired
	private SessionFactory sessionFactory;

	 private Session getSession() {
	        Session session = sessionFactory.getCurrentSession();
	        if (session == null) {
	            session = sessionFactory.openSession();
	        }
	        return session;
	    }

	public void saveUser() {
		Session session1 = getSession();
		UserDetails user1 = new UserDetails("admin","password");
		user1.setUserName("admin");
		user1 = (UserDetails) session1.find(UserDetails.class, user1.getUserName());
	    if(user1!=null){
	    	System.out.println("else condition");
	    }else{
	    	UserDetails user = new UserDetails("admin","password");
	    	UserAddress address = new UserAddress(32,"Kamaraj Street","Chennai","TamilNadu",600900,908767898l); 
			address.setUserDetails(user);
	    	session1.save(user);
	    	session1.save(address);
	    }
	}
	
}
