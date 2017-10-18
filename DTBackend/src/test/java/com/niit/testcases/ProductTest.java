/*package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Ignore
@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class ProductTest {
	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		//product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
	
	}
	

	@Test
	public void createProduct()
	{
		Product product = new Product();
		
		product.setName("Iphone 6s");
		product.setQuantity(4);
	
		product.setPrice(34989.05);
		boolean flag=productDAO.saveProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	
}
*/
