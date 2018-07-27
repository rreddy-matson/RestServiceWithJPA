package com.vehicle.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.demo.dao.VehicleRepo;
import com.vehicle.demo.model.Vehicle;
import com.vehicle.demo.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleRepo repo;
	@Autowired
	VehicleService service;
	@GetMapping(value="/vehicle")
	public List<Vehicle> getVehicles()
	{
		return service.getVehicles();
	}
	
	@GetMapping(value="/vehicle/{id}")
	public Vehicle getVehicle( @PathVariable int id)
	{
		return service.getVehicle(id);
	}
	
	@GetMapping(value="/vehicle/transportMedium/{mediumOfTransport}")
	public List<Vehicle> getVehicleMediumOfTransport( @PathVariable String mediumOfTransport)
	{
		return service.getVehicleMediumOfTransport(mediumOfTransport);
	}
	
	@GetMapping(value="/vehicle/type/{vehicleType}")
	public List<Vehicle> getVehicleType( @PathVariable String vehicleType)
	{
		return service.getVehicleType(vehicleType);
	}
	
	@PostMapping(value="/vehicle" ,consumes= {"application/json"})
	public Vehicle addVehicle(@RequestBody Vehicle vehicle)
	{
		
		return service.addVehicle(vehicle);
	}
	
	@DeleteMapping(value="/vehicle/{id}")
	public String deleteVehicle( @PathVariable int id)
	{
		return service.deleteVehicle(id);
	}
	
	@PutMapping(value="/vehicle" ,consumes= {"application/json"})
	public Vehicle saveorUpdateVehicle(@RequestBody Vehicle vehicle)
	{
		return service.saveorUpdateVehicle(vehicle);
	}
	
	

}
