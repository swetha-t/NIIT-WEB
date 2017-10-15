package com.niit.dao;

import com.niit.model.Product;

public interface ProductDAO {
public boolean createProduct(Product product);
	
	public boolean getProduct(int id);
	
	public boolean addProduct(Product product);
	
	public boolean updateProduct(int id);
	
	public boolean deleteProduct(int id);
}
