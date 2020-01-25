package com.nt.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.ExternalService.PayPalservice;
import com.nt.dto.TrasactionDetails;
import com.nt.service.OnlineShoppingService;
import com.nt.service.OnlineShoppingServiceImpl;

public class OnlineShoppingTest {
	private static OnlineShoppingService localService=null;
	
	@Mock
	private static PayPalservice mockExternalService=null;
	

	@Before
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
		//create local service
		localService=new OnlineShoppingServiceImpl();
	//set mockExternalService obj
		((OnlineShoppingServiceImpl) localService).setExtService(mockExternalService);
		System.out.println("2"+mockExternalService.hashCode());
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mockExternalService=null;
		localService=null;
	}

	@Test
	public void testPaymentWithValidCardNo() {
		TrasactionDetails txDetails=null;
		//create dumy txDetails
		txDetails=new TrasactionDetails();
		txDetails.setCardNo(1001);
		txDetails.setCardType("Visa");
		txDetails.setAmount(3000.0f);
		txDetails.setTxDate(new Date());
		//generate mock result for external service
		Mockito.when(mockExternalService.verifyCardNumber(1001)).thenReturn(true);
	
	Mockito.when(mockExternalService.doPayment(1001,3000.0f)).thenReturn(txDetails);
	//use service class to actual result
	String actual=localService.payment(1001,3000.0f);
	System.out.println("actual"+actual);
	assertEquals("Payment done for 1001 for amount 3000.0 using CardTye Visa", actual);
	
	}

}
