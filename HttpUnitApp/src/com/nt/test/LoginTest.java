package com.nt.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTest {
private static WebConversation conversion=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conversion=new WebConversation();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conversion=null;
	}

	@Test
	public void testLoginAppWithCredential() {
		WebResponse response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//to get index.html
			response=conversion.getResponse("http://localhost:8089/HttpUnitApp/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values form page
			form.setParameter("uname", "satish");
			form.setParameter("pwd", "meena");
			//submit form
			response1=form.submit();
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	assertEquals("Test1", "Valid Crendtial",actualOutput);
	}//method
	
	@Test
	public void testLoginAppWithInCredential() {
		WebResponse response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//to get index.html
			response=conversion.getResponse("http://localhost:8089/HttpUnitApp/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values form page
			form.setParameter("uname", "satish1");
			form.setParameter("pwd", "meena");
			//submit form
			response1=form.submit();
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	assertEquals("Test2", "Invalid Crendtial",actualOutput);
	}//method

	@Test
	public void testLoginAppWithoutInCredential() {
		WebResponse response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//to get index.html
			response=conversion.getResponse("http://localhost:8089/HttpUnitApp/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values form page
			form.setParameter("uname", "");
			form.setParameter("pwd", "");
			//submit form
			response1=form.submit();
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	assertEquals("Test3", "Provide Inputs",actualOutput);
	}//method
}
