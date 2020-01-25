package com.nt.app;

import java.util.ArrayList;
import java.util.List;

public class Portfolilo {
	private Stock stock;
	private StockMarket market;
	List<Stock> stocks = new ArrayList<>();

	public Double getTotalPrice() {
		Double totalPrice = 0.0;
		for (Stock s : this.stocks) {

			String name = s.getName();
			int quentity = s.getQuantity();
			Double price = market.getPrice(name);
			totalPrice = price * quentity;
		}
		return totalPrice;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public StockMarket getMarket() {
		return market;
	}

	public void setMarket(StockMarket market) {
		this.market = market;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
}
