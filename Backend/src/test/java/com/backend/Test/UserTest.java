package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.UserDao;
import com.backend.config.Dbconfig;
import com.backend.model.User;

@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class UserTest {
	@Autowired
	private static UserDao userDao;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
        userDao=(UserDao) context.getBean("userDao");
		
		
	}

@Test
public void createUser()
{
	User user=new User();
    user.setName("Swetha");
    user.setPassword("swetha");
    
  
    
	boolean flag=userDao.saveUser(user);
	//assertEquals("createUserTestCase", true, flag);
}
}


