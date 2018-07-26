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

@RestController
public class VehicleController {
	
	@Autowired
	VehicleRepo repo;
	
	@GetMapping(value="/vehicle")
	public List<Vehicle> getVehicles()
	{
		return repo.findAll();
	}
	
	@GetMapping(value="/vehicle/{id}")
	public Optional<Vehicle> getVehicle( @PathVariable int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping(value="/vehicle/vehicleByTransportMedium/{mediumOfTransport}")
	public List<Vehicle> getVehicle( @PathVariable String mediumOfTransport)
	{
		return repo.findByMediumOfTransport(mediumOfTransport);
	}
	
	@GetMapping(value="/vehicle/{vehicleType}")
	public List<Vehicle> getVehicleType( @PathVariable String vehicleType)
	{
		return repo.findByVehicleType(vehicleType);
	}
	
	@PostMapping(value="/vehicle" ,consumes= {"application/json"})
	public Vehicle addVehicle(@RequestBody Vehicle vehicle)
	{
		repo.save(vehicle);
		return vehicle;
	}
	
	@DeleteMapping(value="/vehicle/{id}")
	public String deleteVehicle( @PathVariable int id)
	{
		Vehicle vehicle= repo.getOne(id);
		repo.delete(vehicle);
		return id+" deleted";
	}
	
	@PutMapping(value="/vehicle" ,consumes= {"application/json"})
	public Vehicle saveorUpdateVehicle(@RequestBody Vehicle vehicle)
	{
		repo.save(vehicle);
		return vehicle;
	}
	
	

}
