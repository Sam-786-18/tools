package com.nt.service;

public class AirthmeticServiceImpl implements AirtmeticService {

	@Override
	public int add(int x, int y) {
		if(x==0||y==0){
			throw new IllegalArgumentException();
		}
		return x+y;
	}

}
