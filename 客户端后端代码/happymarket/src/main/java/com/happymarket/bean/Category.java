package com.happymarket.bean;

public class Category {
	private int categoryId;
	private int parentId;
	private String categoryName;
	public Category(int categoryId, int parentId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.parentId = parentId;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", parentId=" + parentId + ", categoryName=" + categoryName + "]";
	}
	
	
}
