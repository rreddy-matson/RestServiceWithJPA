package com.vehicle.demo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vehicle.demo.model.Vehicle;
import com.vehicle.demo.service.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=VehicleController.class,secure=false)
public class VehicleControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private VehicleService vehicleService;

	
	Vehicle mockVehicle = new Vehicle (1,"red","audi","land","A6","car");
	String expectedJson= "{id: 1,model:A6,vehicleType:car,make:audi,color:red,mediumOfTransport:land}";
	String expectedJsonArray="[{id: 1,model:A6,vehicleType:car,make:audi,color:red,mediumOfTransport:land}]";
	List<Vehicle> mockVehicleList = new ArrayList<Vehicle>();
	String exampleVehicleJson = "{\"id\":\"1\",\"model\":\"A6\",\"vehicleType\":\"car\",\"make\":\"audi\",\"color\":\"red\",\"mediumOfTransport\":\"land\"}";
	
	@Test
	public void testGetVehicles() {
		mockVehicleList.add(mockVehicle);
		Mockito.when(vehicleService.getVehicles()).thenReturn( mockVehicleList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicle")
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			//System.out.println("testGetVehicles: "+result.getResponse().getContentAsString());
			JSONAssert.assertEquals(expectedJsonArray,result.getResponse().getContentAsString(),false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetVehicleInt() {
		
		Mockito.when(vehicleService.getVehicle(Mockito.anyInt())).thenReturn(mockVehicle);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicle/1")
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(expectedJson,result.getResponse().getContentAsString(),false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetVehicleType() {
		mockVehicleList.add(mockVehicle);		
		Mockito.when(vehicleService.getVehicleType(Mockito.anyString())).thenReturn( mockVehicleList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicle/type/car")
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(expectedJsonArray,result.getResponse().getContentAsString(),false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	public void testGetVehicleMediumOfTransport() {
		mockVehicleList.add(mockVehicle);		
		Mockito.when(vehicleService.getVehicleMediumOfTransport(Mockito.anyString())).thenReturn( mockVehicleList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicle/transportMedium/land")
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(expectedJsonArray,result.getResponse().getContentAsString(),false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddVehicle() {
		Mockito.when(vehicleService.addVehicle(Mockito.any(Vehicle.class))).thenReturn(mockVehicle);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicle")
				.accept(MediaType.APPLICATION_JSON).content(exampleVehicleJson).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse  response= result.getResponse();
			assertEquals(HttpStatus.OK.value(),response.getStatus());
			JSONAssert.assertEquals(expectedJson,result.getResponse().getContentAsString(),false);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteVehicle() {
		Mockito.when(vehicleService.deleteVehicle(Mockito.anyInt())).thenReturn("deleted");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/vehicle/1")
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse  response= result.getResponse();
			assertEquals(HttpStatus.OK.value(),response.getStatus());
			assertEquals("deleted",result.getResponse().getContentAsString());
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveorUpdateVehicle() {
		
		Mockito.when(vehicleService.saveorUpdateVehicle(Mockito.any(Vehicle.class))).thenReturn(mockVehicle);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/vehicle")
				.accept(MediaType.APPLICATION_JSON).content(exampleVehicleJson).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result =mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse  response= result.getResponse();
			assertEquals(HttpStatus.OK.value(),response.getStatus());
			JSONAssert.assertEquals(expectedJson,result.getResponse().getContentAsString(),false);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
