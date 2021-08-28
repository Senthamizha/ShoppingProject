package com.Amazon.Model;

import org.springframework.stereotype.Component;

@Component
public class AddressResponse extends CommonResponse{

	private UserAddress address;
	
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	
	
	
}
