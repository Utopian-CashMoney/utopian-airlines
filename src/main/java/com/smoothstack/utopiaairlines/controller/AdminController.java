package com.smoothstack.utopiaairlines.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;
import com.smoothstack.utopiaairlines.service.AirplaneService;
import com.smoothstack.utopiaairlines.service.FlightService;

@RestController
public class AdminController {
	
	@Autowired
	AirplaneService airplaneService;
	
	@Autowired
	FlightService flightService;

	
//-------------------------------------------------------------------------------------------------------------------------------------
	// CRUD Airplane
	
	
	// Add
	@PostMapping("/routes/airplane/add")
	public String saveAirplane(@RequestBody Airplane airplane) {
		airplaneService.addAirplane(airplane);
		return "Airplane Successfully Added!";
	}
	
	// Read
	@GetMapping("/routes/airplane/read")
	public List<Airplane> getAirplanes() {
		List<Airplane> airplanes = new ArrayList<>();
		airplanes = airplaneService.getAllAirplanes();
		return airplanes;
	}
	
	
	//Update
	@PutMapping("/routes/airplane/update")
	public String updateAirplane(@RequestBody Airplane airplane) {
		airplaneService.updateAirplane(airplane);
		return "Airplane Successfully Upated!";
	}
	
	
	@DeleteMapping("/routes/airplane/delete/{id}")
	public String deleteAirplane(@PathVariable Integer id) {
		airplaneService.deleteAirplane(id);
		return "Airplane Deleted!";
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
		// CRUD Flight
	
	
	// Add
	@PostMapping("/routes/flight/add")
	public String saveFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
		return "Flight Successfully Added!";
	}
	
	// Read all flights
	@GetMapping("/routes/flight/read")
	public List<Flight> getFlights() {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.getAllFlights();
		return flights;
	}
	
	
	// Read all flights by route id
	@GetMapping("/routes/flight/read/route_id/{routeId}")
	public List<Flight> getFlightsByRouteId(@PathVariable Integer routeId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.getAllFlightsByRouteId(routeId);
		return flights;
	}
	
	
	// Read all flights by airplane id
	@GetMapping("/routes/flight/read/airplane_id/{airplaneId}")
	public List<Flight> getFlightsByAirplaneId(@PathVariable Integer airplaneId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.getAllFlightsByAirplaneId(airplaneId);
		return flights;
	}
	
	
	
	
	
	//Update by Flight ID
	@PutMapping("/routes/flight/update")
	public String updateFlight(@RequestBody Flight flight) {
		flightService.updateFlight(flight);
		return "Flight Successfully Upated!";
	}
	
	
	
	//Delete by ID
	@DeleteMapping("/routes/flight/delete/{id}")
	public String deleteFlight(@PathVariable Integer id) {
		flightService.deleteFlight(id);
		return "Flight Deleted!";
	}
	
	
	// Delete By Route ID
	@DeleteMapping("/routes/flight/delete/route_id/{id}")
	public String deleteFlightByRouteId(@PathVariable Integer id) {
		flightService.deleteByRouteId(id);
		return "Flight Deleted!";
	}
	
	// Delete By Airplane ID
	@DeleteMapping("/routes/flight/delete/airplane_id/{id}")
	public String deleteFlightByAirplaneId(@PathVariable Integer id) {
		flightService.deleteByAirplaneId(id);
		return "Flight Deleted!";
	}
}
