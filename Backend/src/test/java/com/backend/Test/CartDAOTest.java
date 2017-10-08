package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.CartDAO;
import com.backend.DAO.ProductDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Cart;

@ComponentScan("com.backend")
public class CartDAOTest {
	@Autowired
	private static CartDAO cartDAO;
	
	
	@SuppressWarnings("resource")
 @BeforeClass
 public static void initialize()
 {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.refresh();
		
		cartDAO=(CartDAO) context.getBean("cartDAO");	
 }
 @Test
 public void createCart()
 {
	 Cart cart=new Cart();
	 cart.setOrderId(1001);
	 cart.setProductId(1231);
	 cart.setCartItemId(12);
	 cart.setPrice(12999);
	 cart.setQuantity(10);
	 cart.setUsername("Swetha");
	 cart.setStatus("shipped");
	 
	 boolean flag=cartDAO.saveCart(cart);
		assertEquals("createCartTestCase", true, flag);
	
 }
 
}
