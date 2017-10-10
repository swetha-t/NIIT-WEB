package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class Cart {

	@Id
	@GeneratedValue
	private int CartItemId;
	private int OrderId,Quantity,ProductId;
	private int Price;
	public int getCartItemId() {
		return CartItemId;
	}
	public void setCartItemId(int cartItemId) {
		CartItemId = cartItemId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}	
}
