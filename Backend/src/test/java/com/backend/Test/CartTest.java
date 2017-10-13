package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.CartDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Cart;


@ComponentScan("com.backend")
public class CartTest {
	@Autowired
	private static CartDAO cartDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.backend.*");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	@Test
	public void createCart()
	{
		Cart cart=new Cart();
		cart.setPrice(1500);
		cart.setProductid(12);
		cart.setProductname("Iphone");
		cart.setQuantity(3);
		cart.setStatus("In process");
		cart.setUsername("Swetha");

		boolean flag=cartDAO.createCart(cart);
		assertEquals("creatCartTestCase",true,flag);
}
	@Ignore
	@Test
	
	public void updateCart()
	{
		Cart cart = new Cart();
		boolean flag=cartDAO.updateCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
	@Ignore
	@Test
	public void deleteCart()
	{
		Cart cart = new Cart();
		
		cart.setPrice(100.23);
		cart.setProductid(23);
		cart.setProductname("ihone");
		cart.setQuantity(10);
		cart.setStatus("y");
		cart.setUsername("swetha");
		boolean flag=cartDAO.deleteCart(39);
		assertEquals("createCartTestCase", true, flag);
	}
	

}