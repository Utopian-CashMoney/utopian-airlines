package com.smoothstack.utopiaairlines.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smoothstack.utopiaairlines.dao.AirplaneDao;
import com.smoothstack.utopiaairlines.entities.Airplane;


@SpringBootTest
@Transactional

@RunWith(MockitoJUnitRunner.class)
class AirplaneServiceTest {
	
	@InjectMocks
	@Autowired
	AirplaneService airplaneService;
	
	@MockBean
	AirplaneDao airplaneDao;

	Airplane airplane;

	// Checks if it correctly outputs all airplanes
	@Test
	void testFindAirplanes() {
		airplane = new Airplane();
		airplane.setId(1);
		airplane.setCapacity(200);
		
		when(airplaneDao.findAll()).thenReturn(Collections.singletonList(airplane));
		
		List<Airplane> airplanes = airplaneService.findAirplanes();
		
		assertEquals(1, airplanes.get(0).getId());
		assertEquals(200, airplanes.get(0).getCapacity());
	}
	
	
	// Checks if it correctly outputs all airplanes by ID
	@Test
	void testFindAirplaneById() {
		airplane = new Airplane();
		airplane.setId(1);
		airplane.setCapacity(200);
		
		when(airplaneDao.findById(1)).thenReturn(Optional.of(airplane));
		
		Optional<Airplane> airplanes = airplaneService.findAirplaneById(1);
		
		assertEquals(1, airplanes.get().getId());
		assertEquals(200, airplanes.get().getCapacity());
	}
	

}
