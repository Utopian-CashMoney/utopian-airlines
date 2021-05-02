package com.smoothstack.utopiaairlines.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
		try {
			Optional<Flight> flights = flightDao.findById(id);
			
			return flights;
		} catch (Exception e) {
			Optional.empty();
		}
		return Optional.empty();
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


	// Read Flights By Departure Date
	public List<Flight> findFlightsByDate(Date date){
		List<Flight> flights = flightDao.findByDate(date);
		return flights;
	}


	//Read all the Flights flying before the provided date
	public List<Flight> findFlightsByDateBefore(Date date){
		List<Flight> flights = flightDao.findByDateBefore(date);
		return flights;
	}


	//Read all the Flights flying after the provided date
	public List<Flight> findFlightsByDateAfter(Date date){
		List<Flight> flights = flightDao.findByDateAfter(date);
		return flights;
	}


	//Read all the Flights flying between the provided date
	public List<Flight> findFlightsByDateBetween(Date dateStart, Date dateEnd){
		List<Flight> flights = flightDao.findByDateBetween(dateStart, dateEnd);
		return flights;
	}



	// Helper Method for updateRouteIdByFlightId()
	// Read Routes By ID
	public Optional<Route> findRouteById(Integer id){
		try {
			Optional<Route> routes = routeDao.findById(id);
			return routes;
		} catch (Exception e) {
			Optional.empty();
		}
		return Optional.empty();

	}




	// Update Whole Flight by providing flight whole body
	public boolean updateFlight(Flight flight){
		flightDao.findById(flight.getId());		
		flightDao.save(flight);
		return true;

	}

	// Update Route ID by Flight ID in Flight
	public void updateRouteIdByFlightId(Integer id, Integer routeId){
		try {
			Optional<Flight> flights = findFlightsById(id);
			Optional<Route> routes = findRouteById(routeId);
			Flight flight = flights.get();
			Route route = routes.get();

			if((flight != null)) {
				route.setId(routeId);
				flight.setRoute(route);	
				flightDao.save(flight);
			}

		} catch (Exception e) {
			Optional.empty();
		}

	}


	// Update Airplane ID by Flight ID in Flight
	public void updateAirplaneIdByFlightId(Integer id, Integer airplaneId){

		try {
			Optional<Flight> flights = findFlightsById(id);
			Optional<Airplane> airplanes = airplaneDao.findById(airplaneId);

			Flight flight = flights.get();
			Airplane airplane = airplanes.get();

			airplane.setId(airplaneId);
			flight.setAirplane(airplane);	
			flightDao.save(flight);
		} catch (Exception e) {
			Optional.empty();
		}
	}


	// Update Departure Date Time by Flight ID in Flight
	public void updateDateTimeByFlightId(Integer id, LocalDateTime dateTime){
		try {
			Optional<Flight> flights = findFlightsById(id);

			Flight flight = flights.get();
			flight.setDepartureTime(dateTime);
			flightDao.save(flight);
		} catch (Exception e) {
			Optional.empty();
		}
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


	// Delete Flight by Departure Date 
	public Integer deleteByDate(Date date) {
		List<Flight> flights = findFlightsByDate(date);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}



}
