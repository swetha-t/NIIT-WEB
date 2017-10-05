package com.backend.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.DAO.ProductDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Product;

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

@Test
public void createProduct()
{
	Product product =new Product();
	product.setName("iphone 7");
	product.setQuantity(1);
	product.setPrice(72000);
	

	boolean flag=productDAO.saveProduct(product);
	assertEquals("createProductTestCase", true, flag);
}
}

