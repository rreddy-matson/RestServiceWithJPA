package com.vehicle.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.demo.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer>

{
	
	List<Vehicle> findByMediumOfTransport(String mediumOfTransport);
	List<Vehicle> findByVehicleType(String vehicleType);
}
