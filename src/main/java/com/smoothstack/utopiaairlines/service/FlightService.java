package com.smoothstack.utopiaairlines.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.utopiaairlines.dao.FlightDao;
import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;


@Service
public class FlightService {

	@Autowired
	FlightDao flightDao;


	// Add Flight
	public void addFlight(Flight flight)  
	{    
		flightDao.save(flight);    
	}  



	// Read all Flights
	public List<Flight> getAllFlights(){
		List<Flight> flights = flightDao.findAll();
		return flights;
	}

	// Read all Flights By Route ID
	public List<Flight> getAllFlightsByRouteId(Integer routeId){
		List<Flight> flights = flightDao.findByRouteId(routeId);
		return flights;
	}


	// Read all Flights By Airplane ID
	public List<Flight> getAllFlightsByAirplaneId(Integer airplaneId){
		List<Flight> flights = flightDao.findByAirplaneId(airplaneId);
		return flights;
	}



	// Update Flight by id
	public void updateFlight(Flight flight){

		flightDao.findById(flight.getId());
		flightDao.save(flight);
	}


	// Delete Flight by ID
	public void deleteFlight(Integer id){
		flightDao.deleteById(id);
	}

	// Delete Flight by Route ID
	public Integer deleteByRouteId(Integer routeId) {
		List<Flight> flights = getAllFlightsByRouteId(routeId);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}



	// Delete Flight by Airplane ID
	public Integer deleteByAirplaneId(Integer routeId) {
		List<Flight> flights = getAllFlightsByAirplaneId(routeId);
		Integer size = flights.size();
		flightDao.deleteAll(flights);
		return size;
	}



}
