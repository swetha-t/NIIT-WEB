package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Column(name="cart_id")
	@Id
	@GeneratedValue
	private int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private int userid;
private int productid;
private String productname;
private double Productprice;
private int quantity;
private double subTotal;
private String status;
private String orderId;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public double getProductprice() {
	return Productprice;
}
public void setProductprice(double productprice) {
	Productprice = productprice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getSubTotal() {
	return subTotal;
}
public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
}