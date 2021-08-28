package com.Amazon.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_list")
public class ItemList {

	@Id
	@Column
	private String itemId;
	@Column
	private String categoryId;
	@Column
	private String title;
	@Column
	private Float actualPrice;
	@Column
	private Float discountPrice;
	@Column
	private Integer discountedPercentage;
	@Column
	private String ratings;
	@Column
	private String numberOfRating;
	@Column
	private String description;
	@Column
	private String imageUrls;
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(Float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public Float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getDiscountedPercentage() {
		return discountedPercentage;
	}
	public void setDiscountedPercentage(Integer discountedPercentage) {
		this.discountedPercentage = discountedPercentage;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getNumberOfRating() {
		return numberOfRating;
	}
	public void setNumberOfRating(String numberOfRating) {
		this.numberOfRating = numberOfRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	@Override
	public String toString() {
		return "ItemList [itemId=" + itemId + ", title=" + title + ", actualPrice=" + actualPrice + ", discountPrice="
				+ discountPrice + ", discountedPercentage=" + discountedPercentage + ", ratings=" + ratings
				+ ", numberOfRating=" + numberOfRating + ", description=" + description + ", imageUrls=" + imageUrls
				+ "]";
	}
	public ItemList(String itemId, String title, Float actualPrice, Float discountPrice, Integer discountedPercentage,
			String ratings, String numberOfRating, String description, String imageUrls) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.actualPrice = actualPrice;
		this.discountPrice = discountPrice;
		this.discountedPercentage = discountedPercentage;
		this.ratings = ratings;
		this.numberOfRating = numberOfRating;
		this.description = description;
		this.imageUrls = imageUrls;
	}
	public ItemList() {
		
	}
	
}
