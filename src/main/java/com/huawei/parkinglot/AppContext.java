package com.huawei.parkinglot;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.service.ParkingAreaService;
import com.huawei.parkinglot.service.VehicleService;

public class AppContext {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Vehicle v1 = (Vehicle) context.getBean("sedan1");
		Vehicle v2 = (Vehicle) context.getBean("suv1");
		Vehicle v3 = (Vehicle) context.getBean("minivan1");
		
		ParkingArea p1 = (ParkingArea) context.getBean("park1");
		ParkingArea p2 = (ParkingArea) context.getBean("park2");


		p1.getPriceList().addPrice(2, 10);
		p1.getPriceList().addPrice(4, 12);
		p1.getPriceList().addPrice(8, 15);
		p1.getPriceList().addPrice(14, 17);
		p1.getPriceList().addPrice(24, 20);
		
		p2.getPriceList().addPrice(2, 10);
		p2.getPriceList().addPrice(4, 12);
		p2.getPriceList().addPrice(8, 15);
		p2.getPriceList().addPrice(14, 17);
		p2.getPriceList().addPrice(24, 20);
		
		p1.parkVehicle(v1);
		p1.parkVehicle(v2);
		p1.parkVehicle(v3);
		
		VehicleService.printVehicleStatus(v1);
		VehicleService.printVehicleStatus(v2);
		
/*		try {
			//TimeUnit.SECONDS.sleep(10);
			TimeUnit.HOURS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
		ParkingAreaService.printStatus(p1);
		ParkingAreaService.printStatus(p2);
		
		p1.unParkVehicle(v1);
		p1.unParkVehicle(v2);
		
		p2.parkVehicle(v1);
		p2.unParkVehicle(v1);
		
		ParkingAreaService.printStatus(p1);
		ParkingAreaService.printStatus(p2);
		
		ParkingAreaService.printPastParkings(p1);
		ParkingAreaService.printPastParkings(p2);
		
		VehicleService.printPastParkings(v1);
		VehicleService.printLastParking(v1);
		VehicleService.printVehicleStatus(v3);
		
	}

}
