package com.vehicledb.vehicledatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicledb.vehicledatabase.domain.Vehicle;
import com.vehicledb.vehicledatabase.domain.VehicleRepository;

@RestController
public class VehicleController {
	@Autowired 
	private VehicleRepository repository;
	
  @RequestMapping("api/vehicles")
  public Iterable<Vehicle> getVehicles() {
	  //Fetch and returns vehicles 
	  return repository.findAll();
  }
}
