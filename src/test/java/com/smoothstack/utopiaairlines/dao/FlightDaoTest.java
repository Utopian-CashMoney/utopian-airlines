package com.smoothstack.utopiaairlines.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Route;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
@SpringBootTest
@Transactional

class FlightDaoTest {
	
    //@Autowired
	//@InjectMocks
	@Mock
    private FlightDao flightDao;
	
    Flight flight;
    Route route;
    Airplane airplane;

    
    // Tests if correct number of flights are returned based on ID
    @Test
    void TestfindById() {
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00"); 	
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	flight.setId(1);
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(1);
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flight.setFirstClassSeats(10);
    	flight.setBusinessSeats(7);
    	flight.setEconomySeats(30);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals("Optional.empty", flightDao.findById(1).toString());
    }
    

    // Tests if correct number of flights are returned based on Route ID
    @Test
    void TestfindByRouteId() {
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00"); 	
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    
    	
    	//when(flightDao.findByRouteId(1)).thenReturn(List.of(flight));
    	
        assertEquals(3, flightDao.findByRouteId(1).size());
    }
    
    
    
    // Tests if correct number of flights are returned based on Airplane ID
    @Test
    void TestfindByAirplaneId() {
    	
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00"); 	 	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flight.setFirstClassSeats(10);
    	flight.setBusinessSeats(7);
    	flight.setEconomySeats(30);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(2, flightDao.findByAirplaneId(2).size());
    }
    
    
    // fix thisssssssss
    
    // Tests if correct number of flights are returned based on Date Time
    @Test
    void TestfindByDate() throws ParseException {
	
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00");
    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2013-09-18"); 	 	
    	 
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flight.setFirstClassSeats(10);
    	flight.setBusinessSeats(7);
    	flight.setEconomySeats(30);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(2, flightDao.findByDate(date).size());
    }    
    
}