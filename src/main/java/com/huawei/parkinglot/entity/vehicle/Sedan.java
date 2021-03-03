package com.huawei.parkinglot.entity.vehicle;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Sedan extends Vehicle{

	
	public Sedan(String licensePlate) {
		
		this.licensePlate = licensePlate;
		this.type = VehicleType.SEDAN;
		this.isParked = false;
		this.currentParking = null;
		//this.pastParkings = new ArrayList<>();
	}
	
	

	
	
}
