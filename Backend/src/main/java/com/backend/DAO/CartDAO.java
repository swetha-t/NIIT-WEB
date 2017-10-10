package com.backend.DAO;

import java.util.List;

import com.backend.model.Cart;

public interface CartDAO 
{
public boolean saveCart(Cart cart);
public  List<Cart> getAllCart();
public boolean updateCart(Cart cart);
}
