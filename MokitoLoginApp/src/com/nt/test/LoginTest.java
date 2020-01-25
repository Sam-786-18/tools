package com.nt.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.nt.dao.LoginDao;
import com.nt.service.LoginDaoImpl;
import com.nt.service.LoginService;

public class LoginTest {
private static LoginService service;
private static LoginDao mockDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//create mock object for dao interface
		mockDao=Mockito.mock(LoginDao.class);
		//set mockDao to service class
		service=new LoginDaoImpl();
		((LoginDaoImpl) service).setDao(mockDao);
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mockDao=null;
		service=null;
	}


	@Test
	public void testWithValidCredential() throws Exception {
		boolean status=false;
		//generate mock result for verify method
		Mockito.when(mockDao.verify("satish", "meena")).thenReturn(1);
		status=service.authenticate("satish", "meena");
		assertTrue(status);
		
	}//method
	


	@Test
	public void testWithInValidCredential() throws Exception {
		boolean status=false;
		//generate mock result for verify method
		Mockito.when(mockDao.verify("satish", "hyd")).thenReturn(0);
		status=service.authenticate("satish", "hyd");
		assertFalse(status);
		
	}//method
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNoCredential() throws Exception{
		boolean status=false;
		//generate mock result for verify method
	status=service.authenticate("","");
	fail("Error is expected, but not raised");
		
		
	}//method
	
}//class
