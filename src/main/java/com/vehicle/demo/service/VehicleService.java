package com.vehicle.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vehicle.demo.dao.VehicleRepo;
import com.vehicle.demo.model.Vehicle;

@Component
public class VehicleService {
	@Autowired
	VehicleRepo repo;
	
	public List<Vehicle> getVehicles()
	{
		return repo.findAll();
	}
	public Vehicle getVehicle(int id) {
		return repo.findById(id).orElse(new Vehicle());
	}
	
	public List<Vehicle> getVehicleType(String vehicleType) {
		return repo.findByVehicleType(vehicleType);
	}
	
	public List<Vehicle> getVehicleMediumOfTransport (String mediumOfTransport)
	{
		return repo.findByMediumOfTransport(mediumOfTransport);
	}
	
	public Vehicle addVehicle( Vehicle vehicle)
	{
		repo.save(vehicle);
		return vehicle;
	}
	public String deleteVehicle(int id)
	{
		Vehicle vehicle= repo.getOne(id);
		repo.delete(vehicle);
		return id+" deleted";
	}
	
	public Vehicle saveorUpdateVehicle(Vehicle vehicle)
	{
		repo.save(vehicle);
		return vehicle;
	}

}
