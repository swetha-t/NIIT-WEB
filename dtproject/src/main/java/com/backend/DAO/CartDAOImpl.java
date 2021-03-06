package com.backend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.model.Cart;

@SuppressWarnings("deprecation")
@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public boolean saveProductToCart(Cart cart) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Transactional
	public Cart getitem(int prodId, int userid) {
		String hql = "from"+" Cart"+" where userid="+userid+" and productid="+prodId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> listCart() {
		List<Cart> cartList= sessionFactory.getCurrentSession().createQuery("from Cart").list();
		return cartList;
	}

	@Transactional
	public void removeCartById(int userid) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete Cart where userid="+userid);
		query.executeUpdate();
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public long cartsize(int userid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("userid", userid));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.count("userid"));
		long count= (Long) c.uniqueResult();
		return count;
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public double CartPrice(int userid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("userid", userid));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.sum("subTotal"));
		double l=  (Double) c.uniqueResult();
		return l;
	}

	@Transactional
	public Cart editCartById(int cart_id) 
	{
		Cart cart=	sessionFactory.getCurrentSession().get(Cart.class,cart_id);	
		return cart;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Cart getCartById(int cart_id) {
		String hql = "from"+" Cart"+" where id=" + cart_id;

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		

		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		
		return null;
	}

@Transactional
	public List<Cart> getCart(int userid) {
		List<Cart> clist= sessionFactory.getCurrentSession().createQuery("from Cart where userId="+userid).list();
		return clist;
	}

@Transactional
public void getCartByStatus(int userid) 
{
	String hql="update Cart set status='P' where userid="+userid;	
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	query.executeUpdate();
}

}