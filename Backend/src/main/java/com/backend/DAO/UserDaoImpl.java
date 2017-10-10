package com.backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.User;

public class UserDaoImpl implements UserDao {
@Autowired
	private SessionFactory sessionFactory;
	public void UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
		
	}
	
	public void insertUser(User user) {
		// TODO Auto-generated method stub

	}

	public User getUserDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean vaildate(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
