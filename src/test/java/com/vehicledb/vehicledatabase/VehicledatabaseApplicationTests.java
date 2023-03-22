package com.vehicledb.vehicledatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


import com.vehicledb.vehicledatabase.web.VehicleController;

@SpringBootTest
class VehicledatabaseApplicationTests {
	
@Autowired 
private VehicleController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
