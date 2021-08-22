package com.Amazon.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User_details")
public class UserDetails {

	@Id
	@Column(nullable = false)
	private String userName;
	
	@Column(name="password")	
	private String password;
	
	@OneToOne(mappedBy = "userDetails")
	private UserAddress address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password + ", address=" + address + "]";
	}
	public UserDetails(String userName, String password, UserAddress address) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
	}
	public UserDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		
	}
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
