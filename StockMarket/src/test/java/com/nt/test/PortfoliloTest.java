package com.nt.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.app.Portfolilo;
import com.nt.app.Stock;
import com.nt.app.StockMarket;

public class PortfoliloTest {
private static StockMarket market=null;


public static StockMarket getMarket() {
	return market;
}
public static void setMarket(StockMarket market) {
	PortfoliloTest.market = market;
}
@BeforeClass
public static void setUp() {
	market=EasyMock.createMock(StockMarket.class);
	EasyMock.expect(market.getPrice("Amzone")).andReturn(500.0);
	EasyMock.replay(market);
}
public void m1() {
	//jcalling dao method
}
	@Test
	public void testGetTotalPrice() {
		Portfolilo pf=new Portfolilo();
		pf.setMarket(market);
		Stock s=new  Stock();
		     s.setName("Amzone");
		s.setQuantity(2);
		pf.setStock(s);
		List<Stock> list=new ArrayList<>();
		list.add(s);
		pf.setStocks(list);
		Double actual=pf.getTotalPrice();
		Double expected=1000.00;
		assertEquals(expected, actual);
		
	}

}
