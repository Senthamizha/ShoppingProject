package com.Amazon.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="category_list")
public class CategoryList {

	@Id
	private String categoryId;
	@Column
	private String categoryName;
	@Column
	private String imageUrl;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryId")
    @Fetch(FetchMode.JOIN)
	private List<ItemList> itemList;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ItemList> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemList> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "CategoryList [categoryId=" + categoryId + ", categoryName=" + categoryName + ", imageUrl=" + imageUrl
				+ ", itemList=" + itemList + "]";
	}

	public CategoryList(String categoryId, String categoryName, String imageUrl, List<ItemList> itemList) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
		this.itemList = itemList;
	}
	public CategoryList(){
		
	}
	
}
