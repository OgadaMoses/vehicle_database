package com.vehicledb.vehicledatabase;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;

import com.vehicledb.vehicledatabase.domain.Owner;
import com.vehicledb.vehicledatabase.domain.OwnerRepository;
import com.vehicledb.vehicledatabase.domain.UserRepository;
import com.vehicledb.vehicledatabase.domain.Vehicle;
import com.vehicledb.vehicledatabase.domain.VehicleRepository;

@SpringBootApplication
public class VehicledatabaseApplication implements CommandLineRunner {
	@Autowired
	private UserRepository urepository;
	private static final Logger logger = LoggerFactory.getLogger(VehicledatabaseApplication.class);
	
	@Autowired 
	private VehicleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run
		(VehicledatabaseApplication.class, args);
	}
	
	@Autowired
	private OwnerRepository orepository; 
	// VehicledatabaseApplication.java run method
	@Override 
  public void run(String...args) throws Exception {
		// Add Owner object and save to database  
		Owner owner1 = new Owner ("Moses", "Ogada");
		Owner owner2 = new Owner ("Moses", "Ogada");
		Owner owner3 = new Owner ("Moses", "Ogada");
		Owner owner4 = new Owner ("Musa", "Otieno");
		Owner owner5 = new Owner ("Mose", "Ogada");
		orepository.saveAll(Arrays.asList(owner1,owner2, owner3, owner4, owner5));
		
		Vehicle vehicle1 = new Vehicle("Toyota", "Harrier", "White", "H-2023", 2023, 3000000, owner1);
		Vehicle vehicle2 = new Vehicle("Nissan", "CRV","White", "C-2023", 2023, 340000, owner2);
		Vehicle vehicle3 = new Vehicle("Nissan", "TIIDA", "Cream", "T-2023", 2023, 1900000, owner3);
		Vehicle vehicle4 = new Vehicle("Toyota", "Prado","White", "P-2023", 2023, 340000, owner2);
		Vehicle vehicle5 = new Vehicle("Honda", "TCX-5", "Cream", "C-2023", 2023, 1900000, owner3);
		
		
		repository.saveAll(Arrays.asList (vehicle1,vehicle2,vehicle3, vehicle4,vehicle5));
		
		for (Vehicle vehicle :repository.findAll()) {
		logger.info(vehicle.getBrand () + " " +
		vehicle.getModel());
			
		}
	}
	
	
}


