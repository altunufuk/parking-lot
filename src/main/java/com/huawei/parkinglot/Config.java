package com.huawei.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.ParkingInfo;
import com.huawei.parkinglot.entity.PriceList;
import com.huawei.parkinglot.entity.vehicle.Minivan;
import com.huawei.parkinglot.entity.vehicle.SUV;
import com.huawei.parkinglot.entity.vehicle.Sedan;
import com.huawei.parkinglot.entity.vehicle.Vehicle;


@Configuration
public class Config {

	@Bean
	public Vehicle sedan1() {
		
		return new Sedan("34 ABC 11");
	}
	
	@Bean
	public Vehicle suv1() {
		
		return new SUV("06 ZXC 88");
	}
	
	@Bean
	public Vehicle minivan1() {
		
		return new Minivan("81 HU 76");
	}
	
	@Bean
	public ParkingArea park1(){
	
		return new ParkingArea(15,"CarPark1","Istanbul",priceList());
	
	}
	
	@Bean
	public ParkingArea park2(){
	
		return new ParkingArea(20,"CarPark2","Ankara",priceList());
	
	}
	
	@Bean
	@Scope("prototype")
	public ArrayList<ParkingInfo> pastParkings(){
				
		return new ArrayList<ParkingInfo>();
	}
	
	@Bean
	@Scope("prototype")
	public ArrayList<Integer> availableSlotList(){
		
		
		return new ArrayList<Integer>();
	}
	
	
	@Bean
	@Scope("prototype")
	public Map<Integer,Integer> prices(){
		
		return new HashMap<Integer,Integer>();
		
	}
	

	
	@Bean
	@Scope("prototype")
	public PriceList priceList(){
	
		return new PriceList();
	}
	
	
	@Bean
	public Map<String,Vehicle> map1(){
	
		return new HashMap<String, Vehicle>();
		
	}
	
	@Bean
	public Map<String, String> map2(){
	
		return new HashMap<String, String>();
		
	}
	
	
	
	
	
}
