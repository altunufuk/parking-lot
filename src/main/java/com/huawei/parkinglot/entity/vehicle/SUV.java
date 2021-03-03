package com.huawei.parkinglot.entity.vehicle;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class SUV extends Vehicle {

	
	public SUV(String licensePlate) {
		
		this.licensePlate = licensePlate;
		this.type = VehicleType.SUV;
		this.isParked = false;
		this.currentParking = null;
		//this.pastParkings = new ArrayList<>();
	}
	
}
