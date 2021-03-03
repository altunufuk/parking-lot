package com.huawei.parkinglot.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.service.VehicleService;


public class ParkingArea {
	
	private String name;
	private int capacity;
	private String city;
	
	
	private PriceList priceList;
	
	@Autowired
	private ArrayList<Integer> availableSlotList;
	// Map of Slot, Car
	@Autowired
	private Map<String,Vehicle> map1;
	// Map of LicensePlate, Slot
	@Autowired
	private Map<String, String> map2;
	@Autowired
	private ArrayList<ParkingInfo> pastParkings;
	
	
	
	public ParkingArea(int capacity, String name, String city, PriceList priceList) {
		this.capacity = capacity;
		this.name = name;
		this.city = city;
		this.priceList = priceList;
		System.out.println("Created parking lot: " + name + " with " + capacity + " slots");
        System.out.println();
	}

	
	public String getName() {
		return name;
	}


	public int getCapacity() {
		return capacity;
	}


	public String getCity() {
		return city;
	}


	public PriceList getPriceList() {
		return priceList;
	}


	public ArrayList<Integer> getAvailableSlotList() {
		return availableSlotList;
	}


	public Map<String, Vehicle> getMap1() {
		return map1;
	}


	public Map<String, String> getMap2() {
		return map2;
	}


	public ArrayList<ParkingInfo> getPastParkings() {
		return pastParkings;
	}

	
	@PostConstruct
	public void init() {
		
		for (int i=1; i<= this.capacity; i++) {
            this.availableSlotList.add(i);
        }
		
	}



	public void parkVehicle(Vehicle vehicle) {
		
		if(vehicle.isParked()) {
			if(this.map2.containsKey(vehicle.getLicensePlate())) {
				System.out.println("This vehicle: " + vehicle.getLicensePlate() + " is already parked at slot: " + this.map2.get(vehicle.getLicensePlate()));
				System.out.println("");
			}
			else {
				System.out.println("This vehicle: " + vehicle.getLicensePlate() + " is already parked at another parking lot.");
				System.out.println("");
			}
		}
		else {
		
			if(this.capacity == 0) {
				System.out.println("Parking lot is not created yet!");
	            System.out.println();
				
			}		
			else if(this.map1.size() == this.capacity) {
				System.out.println("Sorry, parking lot is full.");
	            System.out.println();
			}
			else {
				Collections.sort(availableSlotList);
	            String slot = availableSlotList.get(0).toString();
				this.map1.put(slot,vehicle);
				this.map2.put(vehicle.getLicensePlate(),slot);
				System.out.println("Vehicle :" + vehicle.getLicensePlate() + " is parked at " + this.name + " Slot: " + slot + "\n");
				availableSlotList.remove(0);
				vehicle.setParked(true);
				
				ParkingInfo parkingInfo = new ParkingInfo(this, slot, vehicle);
				vehicle.setCurrentParking(parkingInfo);
				VehicleService.checkIn(vehicle);
				
			}
		
		}
		
	}
		
	
	
	public void unParkVehicle(Vehicle vehicle) {
		
		if(vehicle.isParked()) {
			
			if(this.capacity == 0) {
				System.out.println("Parking lot is not created yet");
	            System.out.println();
			}
			else if(this.map1.size() > 0) {
				
				String slot = this.map2.get(vehicle.getLicensePlate());
				if (slot != null) {
					this.map1.remove(slot);
					this.map2.remove(vehicle.getLicensePlate());
					
					this.availableSlotList.add(Integer.parseInt(slot));
					System.out.println("Vehicle: " + vehicle.getLicensePlate() + " is unparked. Slot number " + slot + " is free.");
	                vehicle.setParked(false);
	                
	                VehicleService.checkOut(vehicle);
	                
				}
				else {
					System.out.println("This vehicle: " + vehicle.getLicensePlate() + " is not parked at this parking area");
	                System.out.println();
				}
				
			}
			else {
				System.out.println("Parking lot is empty. This vehicle: " + vehicle.getLicensePlate() + " is not parked at this parking area");
	            System.out.println();
			}
			
		}
		else {
			System.out.println("This vehicle: " + vehicle.getLicensePlate() + " is not parked yet\n");
		}
		
		
		
	}
	
	
	
}
