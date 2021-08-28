package com.Amazon.Model;

import java.io.Serializable;
import java.util.Objects;

public class UserItem implements Serializable{

	private String userName;
	private String itemId;
	
	public UserItem() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(itemId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserItem other = (UserItem) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(userName, other.userName);
	}

	public UserItem(String userName, String itemId) {
		super();
		this.userName = userName;
		this.itemId = itemId;
	}
	
}
