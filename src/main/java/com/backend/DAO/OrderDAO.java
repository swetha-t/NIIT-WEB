package com.backend.DAO;

import java.util.List;

import com.backend.model.Order;

public interface OrderDAO {
	public boolean OrderDetails();
	public List<Order> getAllOrderDetails();
	public List getOrderDetailsByUser(int userid);
	public List<Order> getTotal(int uid);
}
