package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.ProductDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Product;

import jdk.nashorn.internal.ir.annotations.Ignore;

@SuppressWarnings("unused")
@ComponentScan("com.backend")
public class ProductTest {
	@Autowired
	private static ProductDAO productDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
        productDAO=(ProductDAO) context.getBean("productDAO");
		
		
	}
@Ignore
@Test
public void createProduct()
{
	Product product =new Product();
	product.setName("iphone 7");
	product.setQuantity(1);
	product.setPrice(72000);
	

	boolean flag=productDAO.createProduct(product);
	assertEquals("createProductTestCase", true, flag);
}
@Ignore
@Test
public void retrieveProduct()
{
	Product product=new Product();
	boolean listproduct=productDAO.getProduct(12);
	assertNotNull("problem in getting by id", product);
}

@Test
public void deleteProduct()
{
	Product product = new Product();
	product.setName("iphone7");
	product.setQuantity(10);
	product.setPrice(0.0);
	boolean flag=productDAO.deleteProduct(1);
	assertEquals("createProductTestCase", true, flag);
}
@Ignore
@Test
public void updateProduct1()
{
	Product product = new Product();
	boolean flag=productDAO.updateProduct(product);
	assertEquals("createProductTestCase", true, flag);
}
}

