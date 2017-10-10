package com.backend.DAO;

import java.util.List;

import com.backend.model.Product;

public interface ProductDAO 
{
	//public boolean saveProduct(Product p);
	//public  List getAllProduct();
	 public boolean createProduct(Product product);
	  public boolean getProduct(int id);
	  public boolean updateProduct(Product product);
	  public boolean deleteProduct(int id);
}