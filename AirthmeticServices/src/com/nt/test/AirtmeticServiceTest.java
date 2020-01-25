package com.nt.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.nt.service.AirthmeticServiceImpl;
import com.nt.service.AirtmeticService;
@RunWith(Parameterized.class)
public class AirtmeticServiceTest {
	private static AirtmeticService service=null;
private int p1;
private int p2;
/*public AirtmeticServiceTest() {
	System.out.println("AirthmeticService 0-parm Constructor");
}
	*/public  AirtmeticServiceTest(int p1, int p2) {
		System.out.println("AirthmeticService 2-parm Constructor");
		this.p1 = p1;
		this.p2 = p2;
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=new AirthmeticServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service=null;
	}


	@Test
	public void testAdd() {
		System.out.println("asert");
		assertEquals("result",p1+p2, service.add(p1, p2));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddWithZero() {
		service.add(0,0);
		fail("Execption should be raised");
	}
	@Parameters
	public static Collection<Object[]>data(){
		Object[][] data=new Object[][]{{30,40},{50,60},{-70,-80}};
		return Arrays.asList(data);
	}
}
