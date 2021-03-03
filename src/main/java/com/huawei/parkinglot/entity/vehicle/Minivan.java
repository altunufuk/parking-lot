package com.huawei.parkinglot.entity.vehicle;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Minivan extends Vehicle{
	

	public Minivan(String licensePlate) {
		
		this.licensePlate = licensePlate;
		this.type = VehicleType.MINIVAN;
		this.isParked = false;
		this.currentParking = null;
		//this.pastParkings = new ArrayList<>();
		
	}
	
}
