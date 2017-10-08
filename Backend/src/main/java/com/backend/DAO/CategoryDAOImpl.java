package com.backend.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.saveOrUpdate(category);
		Transaction t=s.beginTransaction();
		t.commit();
		return true;
	}

}
