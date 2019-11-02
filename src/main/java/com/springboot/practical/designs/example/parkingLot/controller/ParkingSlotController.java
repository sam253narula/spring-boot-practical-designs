package com.springboot.practical.designs.example.parkingLot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practical.designs.example.model.Vehicle;
import com.springboot.practical.designs.example.repository.ParkingRepository;
import com.springboot.practical.designs.example.service.ParkingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/system/parkingLot")
public class ParkingSlotController {

	@Autowired
	private ParkingService parkingService;
	
	@Autowired
	private ParkingRepository parkingRepository;

	@GetMapping(value = "/getAllVehicles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> getAllVehiclesinParkingLot() {
		List<Vehicle> vehicleList = parkingService.getVehicleList();
		return vehicleList;
	}
	
	@ApiOperation(value = "parks", notes= "Stores the vehicle details in Repository")
	@PostMapping(value = "/vehicle/park", consumes= MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Vehicle Details stored in repo"),
			@ApiResponse(code = 400, message = "Kindly provide a valid Input, id should be between 1 to 10 and the paking slot should be available")})
	public ResponseEntity<String> park(@RequestBody Vehicle vehicle) { 
		//parkingService.park(vehicle);
		return new ResponseEntity<>(parkingService.park(vehicle), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/vehicle/unPark/{id}")
	String newStudent(@PathVariable Long id) {
		return parkingService.unParkVehicle(id);
	}
	
	/*@GetMapping("/hello")
	String helloSaili() {
		return "Hello Saili";
		
	}*/
	

}
