package com.Amazon.Model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CategoryResponse extends CommonResponse{

	private List<CategoryList> categoryList;
	
	public List<CategoryList> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryList> categoryList) {
		this.categoryList = categoryList;
	}
}
