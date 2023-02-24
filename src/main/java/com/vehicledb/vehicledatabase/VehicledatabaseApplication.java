package com.vehicledb.vehicledatabase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vehicledb.vehicledatabase.domain.Vehicle;
import com.vehicledb.vehicledatabase.domain.VehicleRepository;

@SpringBootApplication
public class VehicledatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicledatabaseApplication.class);
	
	@Autowired 
	private VehicleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run
		(VehicledatabaseApplication.class, args);
	}
	
	// VehicledatabaseApplication.java run method
	@Override 
  public void run(String...args) throws Exception {
		repository.save(new Vehicle("Toyota", "Harrier", "White", "H-2023", 2023, 3000000));
		repository.save(new Vehicle("Nissan", "CRV","White", "C-2023", 2023, 340000));
		repository.save(new Vehicle("Nissan", "TIIDA", "Cream", "T-2023", 2023, 1900000));
	}
}
