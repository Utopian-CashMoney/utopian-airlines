package com.smoothstack.utopiaairlines.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.utopiaairlines.dao.AirplaneDao;
import com.smoothstack.utopiaairlines.dao.FlightDao;
import com.smoothstack.utopiaairlines.dao.RouteDao;
import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.entities.Route;


@Service
public class FlightService {

	@Autowired
	FlightDao flightDao;

	@Autowired
	RouteDao routeDao;

	@Autowired
	AirplaneDao airplaneDao;

	Route route;


	// Add Flight
	public void addFlight(Flight flight)  
	{    
		flightDao.save(flight);    
	}  



	// Read all Flights
	public List<Flight> findFlights(){
		List<Flight> flights = flightDao.findAll();
		return flights;
	}


	// Read Flights By ID
	public Optional<Flight> findFlightsById(Integer id){
		Optional<Flight> flights = flightDao.findById(id);
		return flights;
	}


	// Read Flights By Route ID
	public List<Flight> findFlightsByRouteId(Integer routeId){
		List<Flight> flights = flightDao.findByRouteId(routeId);
		return flights;
	}


	// Read Flights By Airplane ID
	public List<Flight> findFlightsByAirplaneId(Integer airplaneId){
		List<Flight> flights = flightDao.findByAirplaneId(airplaneId);
		return flights;
	}


	// Read Flights By Departure DateTime
	public List<Flight> findFlightsByDateTime(LocalDateTime dateTime){
		List<Flight> flights = flightDao.findByDT(dateTime);
		return flights;
	}



	// Helper Method for updateRouteIdByFlightId()
	// Read Routes By ID
	public Optional<Route> findRouteById(Integer id){
		Optional<Route> routes = routeDao.findById(id);
		return routes;
	}




	// Update Whole Flight by id
	public void updateFlight(Flight flight){
		flightDao.findById(flight.getId());
		flightDao.save(flight);
	}

	// Update Route ID by Flight ID in Flight
	public void updateRouteIdByFlightId(Integer id, Integer routeId){
		Optional<Flight> flights = findFlightsById(id);
		Optional<Route> routes = findRouteById(routeId);

		Flight flight = flights.get();
		Route route = routes.get();

		flight.setId(id);
		route.setId(routeId);
		flight.setRoute(route);	
		flightDao.save(flight);
	}


	// Update Airplane ID by Flight ID in Flight
	public void updateAirplaneIdByFlightId(Integer id, Integer airplaneId){
		Optional<Flight> flights = findFlightsById(id);
		Optional<Airplane> airplanes = airplaneDao.findById(airplaneId);

		Flight flight = flights.get();
		Airplane airplane = airplanes.get();

		flight.setId(id);
		airplane.setId(airplaneId);
		flight.setAirplane(airplane);	
		flightDao.save(flight);
	}


	// Update Departure Date Time by Flight ID in Flight
	public void updateDateTimeByFlightId(Integer id, LocalDateTime dateTime){
		Optional<Flight> flights = findFlightsById(id);

		Flight flight = flights.get();

		flight.setId(id);
		flight.setDeparture_time(dateTime);
		flightDao.save(flight);
	}




	// Delete Flight by ID
	public void deleteFlight(Integer id){
		flightDao.deleteById(id);
	}



	// Delete Flight by Route ID
	public Integer deleteByRouteId(Integer routeId) {
		List<Flight> flights = findFlightsByRouteId(routeId);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}


	// Delete Flight by Airplane ID
	public Integer deleteByAirplaneId(Integer routeId) {
		List<Flight> flights = findFlightsByAirplaneId(routeId);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}
	
	
	// Delete Flight by Departure Date Time
	public Integer deleteByDateTime(LocalDateTime dateTime) {
		List<Flight> flights = findFlightsByDateTime(dateTime);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}



}
