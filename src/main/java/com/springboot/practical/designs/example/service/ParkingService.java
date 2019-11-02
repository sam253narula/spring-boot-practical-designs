package com.springboot.practical.designs.example.service;
import java.util.List;

import com.springboot.practical.designs.example.model.Vehicle;

public interface ParkingService {
	List<Vehicle> getVehicleList();
	String park(Vehicle vehicle);
	String unParkVehicle(Long id);

}
