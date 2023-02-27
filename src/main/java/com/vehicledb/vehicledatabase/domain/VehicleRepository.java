package com.vehicledb.vehicledatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	// Fetch vehicles by brand
	List<Vehicle> findByBrandAndModel(String brand, String model);
    
	// Find Vehicles by color
	List<Vehicle> findByColor(String color);
	
	// Find Vehicles by year 
	List<Vehicle> findByvyear (int vyear);
}
