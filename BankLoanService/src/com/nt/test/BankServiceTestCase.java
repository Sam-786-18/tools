/*
 * 
 *
 */
package com.nt.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.nt.service.BankLoanServiceImpl;
import com.nt.service.BankLoanServices;

/**
 * @author Lenovo
 *
 */
public class BankServiceTestCase {
	public static BankLoanServices service = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
		service = new BankLoanServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
		service = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	@Test()
	public void testCalIntrAmtWithInts() {
		int pAmt = 10000;
		int rate = 2;
		int time = 20;
		float expectedIntrAmt = 4000.0f;
		float actualIntrAmt = 0.0f;
		// get atual results
		actualIntrAmt = service.calIntrAmt(pAmt, rate, time);
		assertEquals("Result2", expectedIntrAmt,actualIntrAmt,0.0f);
	}
	@Test()
	public void testCalIntrAmtFloats() {
		float pAmt = 10000.40f;
		float rate = 2.1f;
		float time = 20.2f;
		float expectedIntrAmt = 4242.16968f;
		float actualIntrAmt = 0.0f;
		// get atual results
		actualIntrAmt = service.calIntrAmt(pAmt, rate, time);
		assertEquals("Result1", expectedIntrAmt, actualIntrAmt,0.1f);

	}

	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testCalIntrAmtWithZero() {
		float actualIntrAmt = 0.0f;
		// get atual results
		actualIntrAmt = service.calIntrAmt(0.0f, 0.0f, 0.0f);
		fail("Exeception is expected but not raised");
	}
	
	@Test()
	public void testCalIntrAmtBigValue() {
		float pAmt = 10000.4f;
		float rate = 2.1f;
		float time = 20.2f;
		float expectedIntrAmt = 4242.16968f;
		float actualIntrAmt = 0.0f;
		// get atual results
		actualIntrAmt = service.calIntrAmt(pAmt, rate, time);
		assertEquals("Result3", expectedIntrAmt, actualIntrAmt,0.0f);
	}
@Test(expected=IllegalArgumentException.class)
public void testCalIntrAmtValidInput()
{
	float pAmt=0.0f;
	float rate=2.1f;
	float time=-3.0f;
	float actualIntrAmt=service.calIntrAmt(pAmt, rate, time);
	fail("Execption caught in privious line");
}

@Test
public void testIsAccoutBlockedWithValidInputs(){
	assertTrue("Result5",service.isAccountBlocked(10000));
	
	
}
@Test
public void testIsAccountBlockedWithValidInputs(){
	assertFalse("Result6",service.isAccountBlocked(30000));
}

@Test(expected=IllegalArgumentException.class)
 public void testIsAccountBlockedWithWrongAccNo(){
	assertTrue("Result7",service.isAccountBlocked(-30001));
	fail("Account No. Is not valid");
	
}

}
