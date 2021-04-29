package com.smoothstack.utopiaairlines.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.xmlunit.util.Convert;

import com.smoothstack.utopiaairlines.dao.FlightDao;
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


    // Tests if correct number of flights are returned based on Route ID
    @Test
    void TestfindByRouteId() {
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00"); 	
    	
    	flight = new Flight();
    	route = new Route();
    	airplane = new Airplane();
    	
    	route.setId(1);
    	flight.setRoute(route);
    	
    	airplane.setId(1);
    	flight.setAirplane(airplane);
    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(10);
    	flight.setBusiness_seats(7);
    	flight.setEconomy_seats(30);
    	flightDao.saveAndFlush(flight);
    	
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
    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(10);
    	flight.setBusiness_seats(7);
    	flight.setEconomy_seats(30);
    	flightDao.saveAndFlush(flight);
    	
        assertEquals(2, flightDao.findByAirplaneId(2).size());
    }
    

    
}