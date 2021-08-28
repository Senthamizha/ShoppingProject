package com.Amazon.Model;

import java.util.List;

import com.Amazon.Repository.CommonRepo;

public class ItemResponse extends CommonResponse{

	private List<ItemList> itemList;
	
	public List<ItemList> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemList> itemList) {
		this.itemList = itemList;
	}
}
