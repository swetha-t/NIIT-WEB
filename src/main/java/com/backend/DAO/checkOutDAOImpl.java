package com.backend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.Cart;

public class checkOutDAOImpl implements CheckOutDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void CheckOutDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	
	
	public List<Cart> getTotal(int uid) {
		
		return (List<Cart>) sessionFactory.getCurrentSession()
				.createQuery("select sum(subTotal) from Cart where userid="+uid).list();

	}

}
