package com.huawei.parkinglot.entity;

import java.util.Date;

import com.huawei.parkinglot.entity.vehicle.Vehicle;

public class ParkingInfo {

	private ParkingArea parkingArea;
	private String slotNo;
	private Vehicle vehicle;
	
	private Date parkingDate;
	private Date unParkingDate;
	private int parkingHours;
	private double parkingCost;
	
	
	
	public ParkingInfo(ParkingArea parkingArea, String slotNo, Vehicle vehicle) {
		this.parkingArea = parkingArea;
		this.slotNo = slotNo;
		this.vehicle = vehicle;
	}
	
	
	public ParkingArea getParkingArea() {
		return parkingArea;
	}
	public void setParkingArea(ParkingArea parkingArea) {
		this.parkingArea = parkingArea;
	}
	public String getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}
	public Date getUnParkingDate() {
		return unParkingDate;
	}
	public void setUnParkingDate(Date unParkingDate) {
		this.unParkingDate = unParkingDate;
	}
	public int getParkingHours() {
		return parkingHours;
	}
	public void setParkingHours(int parkingHours) {
		this.parkingHours = parkingHours;
	}
	public double getParkingCost() {
		return parkingCost;
	}
	public void setParkingCost(double parkingCost) {
		this.parkingCost = parkingCost;
	}
	
	
	
	
}
