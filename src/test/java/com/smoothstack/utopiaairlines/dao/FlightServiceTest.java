package com.smoothstack.utopiaairlines.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Route;
import com.smoothstack.utopiaairlines.service.FlightService;

@SpringBootTest
@Transactional
public class FlightServiceTest {
	
	@Autowired
    private FlightService flightService;
	
    @Autowired
    private FlightDao flightDao;
    Flight flight;
    Route route;
    Airplane airplane;
	
    @MockBean
    FlightDao flightDaoMk;
    
    @Test
    void TestdeleteByRouteId() {
    	
    	LocalDateTime localDateTime = LocalDateTime.parse("2048-05-12T14:00:00"); 	 	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(3);
    	flight.setRoute(route);
    	
    	airplane.setId(3);	
    	flight.setAirplane(airplane);
    	
    	flight.setDeparture_time(localDateTime);
    	flight.setEconomy_seats(13);
    	flight.setBusiness_seats(12);
    	flight.setFirstclass_seats(14);
 
    	flightDao.saveAndFlush(flight);
    	
		List<Flight> flights = flightService.getAllFlightsByRouteId(1);
		Integer size = flights.size();
    	
    	//Integer n = flightService.deleteByRouteId(1);
    	
        assertEquals(2, size);
    }
    
    

	

}
