package com.huawei.parkinglot.entity.vehicle;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.huawei.parkinglot.entity.ParkingInfo;

@Entity
@Table(name = "vehicle")
public abstract class Vehicle {

	@Id
	protected String licensePlate;
	protected VehicleType type;
	protected boolean isParked;
	protected ParkingInfo currentParking;
	@Autowired
	protected ArrayList<ParkingInfo> pastParkings;
	
	
	public boolean isParked() {
		return isParked;
	}
	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public ParkingInfo getCurrentParking() {
		return currentParking;
	}
	public void setCurrentParking(ParkingInfo currentParking) {
		this.currentParking = currentParking;
	}
	public ArrayList<ParkingInfo> getPastParkings() {
		return pastParkings;
	}
	public void setPastParkings(ArrayList<ParkingInfo> pastParkings) {
		this.pastParkings = pastParkings;
	}

	
	
}
