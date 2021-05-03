package com.smoothstack.utopiaairlines.service;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smoothstack.utopiaairlines.dao.AirplaneDao;
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
	@Autowired
	FlightService flightService;

	@MockBean
	FlightDao flightDao;

	@MockBean
	RouteDao routeDao;

	@MockBean
	AirplaneDao airplaneDao;

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

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(10);
		flight.setBusinessSeats(20);
		flight.setEconomySeats(30);


		when(flightDao.findById(1)).thenReturn(Optional.of(flight));

		Optional<Flight> flights = flightService.findFlightsById(1);

		assertEquals(localDateTime, flights.get().getDepartureTime());
		assertEquals(10, flights.get().getFirstClassSeats());
		assertEquals(20, flights.get().getBusinessSeats());
		assertEquals(30, flights.get().getEconomySeats());
	}



	// Checks of correct Flight is returned when Route ID is given
	@Test
	public void TestGetFlightsByRouteId()
	{

		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2025-01-14T12:30:30"); 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(10);
		flight.setBusinessSeats(15);
		flight.setEconomySeats(20);

		//Modified for Java 1.8 compliance. -Joshua
		when(flightDao.findByRouteId(1)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByRouteId(1);

		assertEquals(localDateTime, flights.get(0).getDepartureTime());
		assertEquals(10, flights.get(0).getFirstClassSeats());
		assertEquals(15, flights.get(0).getBusinessSeats());
		assertEquals(20, flights.get(0).getEconomySeats());
	}


	// Checks if correct Flight is returned when Arplane ID is given
	@Test
	public void TestGetFlightsByAirplaneId()
	{	
		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2027-12-25T16:45:25"); 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(5);
		flight.setBusinessSeats(7);
		flight.setEconomySeats(9);



		//Modified for Java 1.8 compliance. -Joshua
		when(flightDao.findByAirplaneId(1)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByAirplaneId(1);

		assertEquals(localDateTime, flights.get(0).getDepartureTime());
		assertEquals(5, flights.get(0).getFirstClassSeats());
		assertEquals(7, flights.get(0).getBusinessSeats());
		assertEquals(9, flights.get(0).getEconomySeats());
	}




	// Checks of correct Flight is returned when Date is given
	@Test
	public void TestGetFlightsByDate() throws ParseException
	{	
		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2014-09-18T19:35:15"); 

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 	 	 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(7);
		flight.setBusinessSeats(12);
		flight.setEconomySeats(14);


		when(flightDao.findByDate(date)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByDate(date);

		assertEquals("2014-09-18", flights.get(0).getDepartureTime().toLocalDate().toString());
		assertEquals(7, flights.get(0).getFirstClassSeats());
		assertEquals(12, flights.get(0).getBusinessSeats());
		assertEquals(14, flights.get(0).getEconomySeats());	
	}



	// Checks of correct Flight is returned when Date Before is given
	@Test
	public void TestGetFlightsByDateBefore() throws ParseException
	{	
		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2013-09-18T19:35:15"); 

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 	 	 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(7);
		flight.setBusinessSeats(12);
		flight.setEconomySeats(14);


		when(flightDao.findByDateBefore(date)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByDateBefore(date);

		assertEquals("2013-09-18", flights.get(0).getDepartureTime().toLocalDate().toString());

		assertEquals(7, flights.get(0).getFirstClassSeats());
		assertEquals(12, flights.get(0).getBusinessSeats());
		assertEquals(14, flights.get(0).getEconomySeats());	
	}

	// Checks of correct Flight is returned when Date After is given
	@Test
	public void TestGetFlightsByDateAfter() throws ParseException
	{	
		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2016-09-18T19:35:15"); 

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 	 	 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(7);
		flight.setBusinessSeats(12);
		flight.setEconomySeats(14);


		when(flightDao.findByDateAfter(date)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByDateAfter(date);

		assertEquals("2016-09-18", flights.get(0).getDepartureTime().toLocalDate().toString());

		assertEquals(7, flights.get(0).getFirstClassSeats());
		assertEquals(12, flights.get(0).getBusinessSeats());
		assertEquals(14, flights.get(0).getEconomySeats());	
	}



	// Checks of correct Flight is returned when Date Between is given
	@Test
	public void TestGetFlightsByDateBetween() throws ParseException
	{	
		flight = new Flight();
		LocalDateTime localDateTime = LocalDateTime.parse("2015-09-18T19:35:15"); 

		Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 
		Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-18"); 	 

		flight.setDepartureTime(localDateTime);
		flight.setFirstClassSeats(7);
		flight.setBusinessSeats(12);
		flight.setEconomySeats(14);


		when(flightDao.findByDateBetween(dateStart, dateEnd)).thenReturn(Collections.singletonList(flight));

		List<Flight> flights = flightService.findFlightsByDateBetween(dateStart, dateEnd);

		assertEquals("2015-09-18", flights.get(0).getDepartureTime().toLocalDate().toString());

		assertEquals(7, flights.get(0).getFirstClassSeats());
		assertEquals(12, flights.get(0).getBusinessSeats());
		assertEquals(14, flights.get(0).getEconomySeats());	
	}


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



	// Checks if given route id is present then if it present then it deletes that flight
	@Test
	public void TestDeleteByRouteId() throws ParseException
	{	
		ArrayList<Flight> flights = new ArrayList<>();

		flight = new Flight();
		route = new Route();
		airplane = new Airplane();

		route.setId(1);
		flights.add(flight);
		
		 when(flightDao.findByRouteId(1)).thenReturn(
				 flights.stream().filter(flight -> route.getId().equals(1))
	                        .collect(Collectors.toList()));

		assertEquals(1,flightService.deleteByRouteId(1));

	}
	
	
	// Checks if given airplane id is present then if it present then it deletes that flight
	@Test
	public void TestDeleteByAirplaneId() throws ParseException
	{	
		ArrayList<Flight> flights = new ArrayList<>();

		flight = new Flight();
		route = new Route();
		airplane = new Airplane();

		airplane.setId(1);
		flights.add(flight);
		
		 when(flightDao.findByAirplaneId(1)).thenReturn(
				 flights.stream().filter(flight -> airplane.getId().equals(1))
	                        .collect(Collectors.toList()));

		assertEquals(1,flightService.deleteByAirplaneId(1));

	}
	
	
	
	// Checks if given date is present then if it present then it deletes that flight
	@Test
	public void TestDeleteByDate() throws ParseException
	{	
		ArrayList<Flight> flights = new ArrayList<>();

		flight = new Flight();
		route = new Route();
		airplane = new Airplane();
		LocalDateTime localDateTime = LocalDateTime.parse("2014-09-18T19:35:15");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-18"); 
		
		
		flight.setDepartureTime(localDateTime);
		flights.add(flight);
		
		 when(flightDao.findByDate(date)).thenReturn(
				 flights.stream().filter(flight -> flight.getDepartureTime().equals(localDateTime))
	                        .collect(Collectors.toList()));

		assertEquals(1,flightService.deleteByDate(date));

	}

}
