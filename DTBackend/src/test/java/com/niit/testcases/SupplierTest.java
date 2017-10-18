/*package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Ignore
@ComponentScan("com.niit")
public class SupplierTest {
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
	
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	public void createSupplier()
	{
		Supplier supplier = new Supplier();
		supplier.setSupName("prime");
		boolean flag=supplierDAO.saveSupplier(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateSupplier()
	{
		Supplier supplier = new Supplier();
		//boolean flag=supplierDAO.getSupplierById(supplier_id);
		//assertEquals("createSupplierTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void deleteSupplier()
	{
		//boolean flag=supplierDAO.removeSupplierById(140);
	//	assertEquals("createSupplierTestCase", true, flag);
	}
}
*/
