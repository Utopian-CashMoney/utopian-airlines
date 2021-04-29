package com.ss.smoothstack.utopiaairlines.dao;

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

//@SpringBootTest
@Transactional

class AirplaneDaoTest {
    @Autowired
    private FlightDao flightDao;
    Flight flight;
    Route route;
    Airplane airplane;

    @BeforeEach
    void setUp() {
   
    	LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T20:40:00");
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	//String formatDateTime = localDateTime.format(formatter);
    	
    	
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
    	flightDao.findAll().forEach(System.out::println);
    }


    @Test
    void TestfindByRouteId() {
        assertEquals(1, flightDao.findByRouteId(1).size());
    }
    
}