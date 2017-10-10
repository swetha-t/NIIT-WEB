package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.model.Cart;


@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

public boolean saveCart(Cart cart) {
	Session s=sessionFactory.openSession();
	s.saveOrUpdate(cart);
	//s.flush();
	Transaction t=s.beginTransaction();
	t.commit();
	return true;

}
	@SuppressWarnings("unchecked")
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
	}

	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

}
