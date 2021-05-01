package com.smoothstack.utopiaairlines.service;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smoothstack.utopiaairlines.dao.FlightDao;
import com.smoothstack.utopiaairlines.dao.RouteDao;
import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Airport;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Route;

@SpringBootTest
@Transactional

@RunWith(MockitoJUnitRunner.class)
class FlightServiceTest {

	@InjectMocks
	//@Autowired
	FlightService flightService;
	
	@Mock
   // @MockBean
	FlightDao flightDao;
	
	@Mock
    //@MockBean
	RouteDao routeDao;

	Airplane airplane;
    Airport airport;
	Route route;
    Flight flight;
	

	// Checks of correct Flight is returned when id is given
	@Test
	public void TestGetFlightsById()
	{	
    	flight = new Flight();

    	LocalDateTime localDateTime = LocalDateTime.parse("2030-11-21T01:30:30"); 
    	    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(10);
    	flight.setBusiness_seats(20);
    	flight.setEconomy_seats(30);
    	
		
		when(flightDao.findById(1)).thenReturn(Optional.of(flight));
		
		Optional<Flight> flights = flightService.findFlightsById(1);

		assertEquals(localDateTime, flights.get().getDeparture_time());
		assertEquals(10, flights.get().getFirstclass_seats());
		assertEquals(20, flights.get().getBusiness_seats());
		assertEquals(30, flights.get().getEconomy_seats());	
	}
	
	
	
	// Checks of correct Flight is returned when Route ID is given
	@Test
	public void TestGetFlightsByRouteId()
	{	
		//ArrayList<Flight> mockData = new ArrayList<>();
		
    	flight = new Flight();
    	LocalDateTime localDateTime = LocalDateTime.parse("2025-01-14T12:30:30"); 
    	    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(10);
    	flight.setBusiness_seats(15);
    	flight.setEconomy_seats(20);
    	
    	//mockData.add(flight);
    		
		when(flightDao.findByRouteId(1)).thenReturn(List.of(flight));
		
		List<Flight> flights = flightService.findFlightsByRouteId(1);

		assertEquals(localDateTime, flights.get(0).getDeparture_time());
		assertEquals(10, flights.get(0).getFirstclass_seats());
		assertEquals(15, flights.get(0).getBusiness_seats());
		assertEquals(20, flights.get(0).getEconomy_seats());	
	}
	
	
	// Checks of correct Flight is returned when Arplane ID is given
	@Test
	public void TestGetFlightsByAirplaneId()
	{	
    	flight = new Flight();
    	LocalDateTime localDateTime = LocalDateTime.parse("2027-12-25T16:45:25"); 
    	    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(5);
    	flight.setBusiness_seats(7);
    	flight.setEconomy_seats(9);
    	
		
		when(flightDao.findByAirplaneId(1)).thenReturn(List.of(flight));
		
		List<Flight> flights = flightService.findFlightsByAirplaneId(1);

		assertEquals(localDateTime, flights.get(0).getDeparture_time());
		assertEquals(5, flights.get(0).getFirstclass_seats());
		assertEquals(7, flights.get(0).getBusiness_seats());
		assertEquals(9, flights.get(0).getEconomy_seats());	
	}
	
	
	// Fix thissssssssss
	
	/*
	// Checks of correct Flight is returned when Date Time is given
	@Test
	public void TestGetFlightsByDateTime()
	{	
    	flight = new Flight();
    	LocalDateTime localDateTime = LocalDateTime.parse("2031-12-25T19:35:15"); 
    	    	
    	flight.setDeparture_time(localDateTime);
    	flight.setFirstclass_seats(7);
    	flight.setBusiness_seats(12);
    	flight.setEconomy_seats(14);
    	
		
		when(flightDao.findByDT(localDateTime)).thenReturn(List.of(flight));
		
		List<Flight> flights = flightService.findFlightsByDateTime(localDateTime);

		assertEquals(localDateTime, flights.get(0).getDeparture_time());
		assertEquals(7, flights.get(0).getFirstclass_seats());
		assertEquals(12, flights.get(0).getBusiness_seats());
		assertEquals(14, flights.get(0).getEconomy_seats());	
	}*/
	
	// FINISH REST TEST HERE
	
	
	// Checks of correct route is returned when id is given
	@Test
	public void TestGetRouteById()
	{	
    	route = new Route();

    	route.setId(1);
    	    	
		when(routeDao.findById(1)).thenReturn(Optional.of(route));
		
		Optional<Route> routes = flightService.findRouteById(1);
	
		assertEquals("1", routes.get().getId().toString());
	}
	
	
	/*// Checks of correct route is returned when id is given
	@Test
	public void TestupdateRouteIdById()
	{	
    	//route = new Route();
		

    	//route.setId(1);
    	//flight.setId(1);
    	    	
		//
		
		//Optional<Route> routes = flightService.findRouteById(1);
	
		flight = new Flight();
		route = new Route();
		airplane = new Airplane();
		LocalDateTime localDateTime = LocalDateTime.parse("2030-11-21T01:30:30"); 
	//	assertFalse(flightService.updateFlight(flight));
	
		
		flight.setId(1);
		
		route.setId(1);
		flight.setRoute(route);
		
		airplane.setId(1);
		flight.setAirplane(airplane);
		flight.setDeparture_time(localDateTime);
		
		flight.setFirstclass_seats(10);
		flight.setBusiness_seats(15);
		flight.setEconomy_seats(20);
		
		when(flightService.updateRouteIdByFlightId(1, 2)).thenReturn(true);

		
		assertTrue(flightService.updateRouteIdByFlightId(1,2));
				
		
	}*/
	
	
	

}