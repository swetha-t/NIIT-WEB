package com.backend.DAO;

import java.util.List;

import com.backend.model.Category;
import com.backend.model.Product;

public interface CategoryDAO {
  
	 public boolean saveCategory(Category category);
	  public boolean getCategory(int catid);
	  public boolean updateCategory(Category category);
	  public boolean deleteCategory(Category category);
}