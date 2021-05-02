package com.smoothstack.utopiaairlines.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Route;  
@SpringBootTest
@Transactional

class FlightDaoTest {
	
    @Autowired
    private FlightDao flightDao;
	
    Flight flight;
    Route route;
    Airplane airplane;    
    
    
    // Tests if correct number of flights are returned based on Date
    @Test
    void TestfindByDate() throws ParseException {
	
    	LocalDateTime localDateTime = LocalDateTime.parse("2014-09-18T20:40:00");
    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 	 	 
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(1, flightDao.findByDate(date).size());
    }  
    
    
    
    // Tests if correct number of flights are returned based on Date Before
    @Test
    void TestfindByDateBefore() throws ParseException {
	
    	LocalDateTime localDateTime = LocalDateTime.parse("0001-01-01T20:40:00");
    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse("0002-01-01"); 	 	 
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(1, flightDao.findByDateBefore(date).size());
    } 
    
    
    
    
    // Tests if correct number of flights are returned based on Date After
    @Test
    void TestfindByDateAfter() throws ParseException {
	
    	LocalDateTime localDateTime = LocalDateTime.parse("2999-12-31T20:40:00");
    	Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2998-12-30"); 	 	 
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(1, flightDao.findByDateAfter(date).size());
    } 
    
    
    // Tests if correct number of flights are returned based on Date Between
    @Test
    void TestfindByDateBetween() throws ParseException {
	
    	LocalDateTime localDateTime = LocalDateTime.parse("0002-01-01T20:40:00");
    	Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse("0001-01-01"); 	
    	Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse("0003-01-01"); 	
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(2);	
    	flight.setAirplane(airplane);
    	
    	flight.setDepartureTime(localDateTime);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(1, flightDao.findByDateBetween(dateStart, dateEnd).size());
    } 
    
    
}