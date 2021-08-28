package com.Amazon.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "cart_details")
@IdClass(UserItem.class)
public class CartItem extends CommonResponse{

	@Id
	@Column
	private String userName;
	@Id
	@Column
	private String itemId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public CartItem(String userName, String itemId) {
		super();
		this.userName = userName;
		this.itemId = itemId;
	}
	public CartItem() {
		
	}
}
