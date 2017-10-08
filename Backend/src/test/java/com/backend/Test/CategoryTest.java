package com.backend.Test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.CategoryDAO;
import com.backend.config.Dbconfig;
import com.backend.model.Category;

@ComponentScan("com.backend")
public class CategoryTest 
{
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.refresh();
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	@Test
	public void createCategory()
	{
		Category category=new Category();
		//category.setCatId(1);
		category.setCategoryName("MOTO");
		category.setCategoryDescription("Andriod ");
		//boolean flag=categoryDAO.saveCategory(category);
		//assertEquals("createCategoryTestCase", true, flag);
		
	}
	
}


