package com.huawei.parkinglot.entity;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class PriceList {
	
	@Autowired
	private Map<Integer,Integer> prices;
	
	public PriceList() {
		
		
	}
	
	
	
	public Map<Integer, Integer> getPrices() {
		return prices;
	}



	public void setPrices(Map<Integer, Integer> prices) {
		this.prices = prices;
	}



	/*
	0-2   10TL -> addPrice(2,10)
	2-4   12TL -> addPrice(4,12)
	4-8   15TL -> addPrice(8,15)
	8-14  17TL -> addPrice(14,17)
	14-24 20TL -> addPrice(24,20)
	*/
	public void addPrice(int upperRange, int price) {
		
		prices.put(upperRange, price);
		
	}
}
