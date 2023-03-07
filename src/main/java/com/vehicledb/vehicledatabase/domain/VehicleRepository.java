package com.vehicledb.vehicledatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(exported = false)
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	// Fetch vehicles by brand
	List<Vehicle> findByBrandAndModel(@Param ("brand") String brand, @Param("model") String model);
    
	// Find Vehicles by color
	List<Vehicle> findByColor(@Param ("color") String color);
	
	// Find Vehicles by year 
	List<Vehicle> findByvyear (int vyear);
}
