package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

@Transactional
	public boolean saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}



	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void removeUserById(int user_id) {
		
	}

	@Transactional
	public User get(String email){
		@SuppressWarnings("deprecation")
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}

	

	public List<User> list() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
		return users;
	}

}
	