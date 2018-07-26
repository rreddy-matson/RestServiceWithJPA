package com.vehicle.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMediumOfTransport() {
		return mediumOfTransport;
	}
	public void setMediumOfTransport(String mediumOfTransport) {
		this.mediumOfTransport = mediumOfTransport;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	private int id;
	private String model;
	private String vehicleType;
	private String make;
	private String color;
	private String mediumOfTransport;
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", vehicleType=" + vehicleType + ", make=" + make + ", color="
				+ color + ", mediumOfTransport=" + mediumOfTransport + "]";
	}
	

}
