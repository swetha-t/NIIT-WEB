package com.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.backend.DAO.CartDAO;
import com.backend.DAO.CartDAOImpl;
import com.backend.DAO.CategoryDAO;
import com.backend.DAO.CategoryDAOImpl;
import com.backend.DAO.ProductDAO;
import com.backend.DAO.ProductDAOImpl;
import com.backend.DAO.SupplierDAO;
import com.backend.DAO.SupplierDAOImpl;
import com.backend.DAO.UserDAO;
import com.backend.DAO.UserDAOImpl;
import com.backend.model.Cart;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.Supplier;
import com.backend.model.User;

@Configuration
@ComponentScan("com.backend")
@EnableTransactionManagement
@Component
public class Dbconfig  
{     
	@Autowired
	@Bean(name = "dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test2");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");
			System.out.println("Datasource");
			return dataSource;

		}

		private Properties getHibernateProperties() 
		{
			Properties properties = new Properties();
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.hbm2ddl.auto", "update");
			System.out.println("Hibernate Properties");
			return properties;

		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(Cart.class);
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.scanPackages("com.backend.*");
			System.out.println("Session");
			
			
			return sessionBuilder.buildSessionFactory();
			
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			System.out.println("Transaction");
			return transactionManager;
		}
	//Factory Design pattern
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) 
	{
	    return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		return new CartDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		return new UserDAOImpl(sessionFactory);
	}
}