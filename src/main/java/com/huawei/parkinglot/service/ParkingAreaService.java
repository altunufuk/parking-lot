package com.huawei.parkinglot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.ParkingInfo;
import com.huawei.parkinglot.entity.vehicle.Vehicle;

public class ParkingAreaService {

	public static void printStatus(ParkingArea parkingArea) {
		
        if (parkingArea.getCapacity() == 0) {
            System.out.println("Sorry, parking lot is not created yet");
            System.out.println();
        } 
        else if (parkingArea.getMap1().size() > 0) {
            // Print the current status.
        	System.out.println(parkingArea.getName() + " - " + parkingArea.getCity());
            System.out.println("Slot No.\tLicense Plate\t\tVehicle Type");
            Vehicle vehicle;
            for (int i = 1; i <= parkingArea.getCapacity(); i++) {
                String key = Integer.toString(i);
                if (parkingArea.getMap1().containsKey(key)) {
                    vehicle = parkingArea.getMap1().get(key);
                    System.out.println(i + "\t\t" + vehicle.getLicensePlate() + "\t\t" + vehicle.getType());
                }              
            }
            System.out.println();
        } else {
            System.out.println("Parking lot: " + parkingArea.getName() + " is empty");
            System.out.println();
        }
        
    }
	
	public static void printPastParkings(ParkingArea parkingArea) {
		
		ArrayList<ParkingInfo> pastParkings = parkingArea.getPastParkings();
		
		if(pastParkings.size()>0) {
		
			System.out.println("Parking history of " + parkingArea.getName() + " - " + parkingArea.getCity());
			System.out.println("-----------------------------------------");
			for(ParkingInfo parkingInfo:pastParkings) {
				
				System.out.println("Vehicle: " + parkingInfo.getVehicle().getLicensePlate() + " - " + parkingInfo.getVehicle().getType() +
						" Slot No: " + parkingInfo.getSlotNo() + "\nParking Date: " + parkingInfo.getParkingDate() +
						" Unparking Date: " + parkingInfo.getUnParkingDate() + " Parking cost: " + parkingInfo.getParkingCost() + " TL\n");		
			}
		
		}
		else {
			
			System.out.println("There is no parking history for : " + parkingArea.getName() + "\n");
			
		}
		
	}
	
	public static double getDailyIncome(ParkingArea parkingArea) {
		
		double dailyIncome=0;
		final long DAY = 24 * 60 * 60 * 1000;
		ArrayList<ParkingInfo> pastParkings = parkingArea.getPastParkings();
		
		List<ParkingInfo> lastDayParkings = pastParkings.stream()
				.filter(p -> p.getParkingDate().getTime() > (System.currentTimeMillis() - DAY))
				.collect(Collectors.toList());
		
		
		for(ParkingInfo p:lastDayParkings) {
			
			dailyIncome += p.getParkingCost();
			
		}
		
		return dailyIncome;
		
	}
	
}
