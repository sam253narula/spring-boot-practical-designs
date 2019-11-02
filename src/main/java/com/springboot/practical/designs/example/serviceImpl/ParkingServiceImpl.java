package com.springboot.practical.designs.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practical.designs.example.model.Vehicle;
import com.springboot.practical.designs.example.repository.ParkingRepository;
import com.springboot.practical.designs.example.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	ParkingRepository parkingRepository;
	
	@Override
	public List<Vehicle> getVehicleList() {
		 return parkingRepository.findAll();
	}
	
	@Override
	public String park(Vehicle vehicle) {
		 long id = vehicle.getId();
		 List<Vehicle> parkedVehicles = new ArrayList<>();
		 parkedVehicles = parkingRepository.findAll();
		 boolean available = true;
		 for(Vehicle v: parkedVehicles) {
			 if(v.getId() == id) {
				 available = false; 
				 throw new RuntimeException("Slot not available");
			 }
		 }
		 if (vehicle.getId() <= 10 && vehicle.getId() != 0) {
			parkingRepository.save(vehicle);
			return "Parked";
		}
		 else {
			 throw new RuntimeException("Provide Id between 1 to 10");
		 }
		
	}

	@Override
	public String unParkVehicle(Long id) {
		if (id <= 10) {
			parkingRepository.delete(id);
			return "Parking slot " + id + " is now available";
		}
		throw new RuntimeException("Provide id between 1 to 10");
	}

}
