package com.huawei.parkinglot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import com.huawei.parkinglot.entity.ParkingInfo;
import com.huawei.parkinglot.entity.PriceList;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.entity.vehicle.VehicleType;


public class VehicleService {
	

	public static void checkIn(Vehicle vehicle) {
		
		vehicle.getCurrentParking().setParkingDate(new Date());
		
	}
	public static void checkOut(Vehicle vehicle) {
		
		ParkingInfo currentParking = vehicle.getCurrentParking();
		
		currentParking.setUnParkingDate(new Date());
		currentParking.setParkingHours(hoursDifference(currentParking.getParkingDate(), currentParking.getUnParkingDate()));
		currentParking.setParkingCost(parkingCost(vehicle));
		
		System.out.println("Vehicle: " + vehicle.getLicensePlate() + " parking cost: " + currentParking.getParkingCost() + " TL\n");
		vehicle.getPastParkings().add(currentParking);
		currentParking.getParkingArea().getPastParkings().add(currentParking);
		vehicle.setCurrentParking(null);
	}
	
	
	public static int hoursDifference(Date parkingDate, Date unParkingDate) {
		
		final int MILLI_TO_HOUR = 1000 * 60 * 60;	
		return (int) (unParkingDate.getTime() - parkingDate.getTime()) / MILLI_TO_HOUR;
		
	}
	
	public static double parkingCost(Vehicle vehicle) {
		
		int priceKey=0;
		int price;
		double cost=0;
		PriceList priceList = vehicle.getCurrentParking().getParkingArea().getPriceList();
		int parkingHours = vehicle.getCurrentParking().getParkingHours();
		VehicleType vehicleType = vehicle.getType();
		
		java.util.Set<Integer> keys = priceList.getPrices().keySet();
		TreeSet<Integer> sortedKeys = new TreeSet<Integer>(keys);

		for(int key:sortedKeys) {
			
			if(parkingHours<key) {
				priceKey = key;
				break;
			}
		}
		price = priceList.getPrices().get(priceKey);
		
		if(vehicleType==VehicleType.SEDAN) {
			
			cost = parkingHours * price;
			
		}
		else if(vehicleType==VehicleType.SUV) {
			
			cost = (parkingHours * (price * 1.1));
			
		}
		else if(vehicleType==VehicleType.MINIVAN) {
			
			cost = (parkingHours * (price * 1.15));
		}
		
		return cost;
	}
	
	public static void printVehicleStatus(Vehicle vehicle) {
		
		if(vehicle.isParked()) {
			System.out.println("Vehicle with license plate: " + vehicle.getLicensePlate() +
					" is parked at " + vehicle.getCurrentParking().getParkingArea().getName() +				
					" Slot no: " + vehicle.getCurrentParking().getSlotNo());
			System.out.println("Vehicle Type: " + vehicle.getType() + " Parking Date: " + vehicle.getCurrentParking().getParkingDate());
			System.out.println("");
		}
		else {
			
			System.out.println("This vehicle is not parked yet\n");			
			
		}
			
	}
	
	public static void printLastParking(Vehicle vehicle) {
		
		ArrayList<ParkingInfo> pastParkings = vehicle.getPastParkings();
		
		if(pastParkings.size()>0) {
			
			ParkingInfo lastParkingInfo = pastParkings.get(pastParkings.size()-1);
			
			System.out.println("Last parking of Vehicle: " + vehicle.getLicensePlate() + " - " + vehicle.getType());
			System.out.println("Parking Area: " + lastParkingInfo.getParkingArea().getName() +
					" Slot No: " + lastParkingInfo.getSlotNo() + " Parking Date: " + lastParkingInfo.getParkingDate() +
					" Unparking Date: " + lastParkingInfo.getUnParkingDate() + " Parking cost: " + lastParkingInfo.getParkingCost() + "\n");		
			
		}
		else {
			
			System.out.println("There is no parking history for Vehicle: " + vehicle.getLicensePlate() + "\n");
			
		}
		
		
		
		
	}
	
	public static void printPastParkings(Vehicle vehicle) {
		
		ArrayList<ParkingInfo> pastParkings = vehicle.getPastParkings();
		
		if(pastParkings.size()>0) {
		
			System.out.println("Past parkings of Vehicle: " + vehicle.getLicensePlate());
			System.out.println("-----------------------------------------");
			for(ParkingInfo parkingInfo:pastParkings) {
				
				System.out.println("Parking Area: " + parkingInfo.getParkingArea().getName() +
						" Slot No: " + parkingInfo.getSlotNo() + " Parking Date: " + parkingInfo.getParkingDate() +
						" Unparking Date: " + parkingInfo.getUnParkingDate() + " Parking cost: " + parkingInfo.getParkingCost() + " TL\n");		
			}
		
		}
		else {
			
			System.out.println("There is no parking history for Vehicle: " + vehicle.getLicensePlate() + "\n");
			
		}
	}

}
