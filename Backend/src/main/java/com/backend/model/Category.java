package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Category {
	
	@Id
	@GeneratedValue
private int CatId;
private String CategoryName;
private String CategoryDescription;
public int getCatId() {
	return CatId;
}
public void setCatId(int catId) {
	CatId = catId;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}
public String getCategoryDescription() {
	return CategoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	CategoryDescription = categoryDescription;
}

}
