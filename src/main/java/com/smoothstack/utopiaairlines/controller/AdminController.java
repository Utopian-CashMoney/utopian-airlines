package com.smoothstack.utopiaairlines.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


	// Add Airplane
	@PostMapping("/routes/airplane/add")
	public String saveAirplane(@RequestBody Airplane airplane) {
		airplaneService.addAirplane(airplane);
		return "Airplane Successfully Added!";
	}

	// Read all Airplanes
	@GetMapping("/routes/airplane/read")
	public List<Airplane> getAirplanes() {
		List<Airplane> airplanes = new ArrayList<>();
		airplanes = airplaneService.findAirplanes();
		return airplanes;
	}

	// Read Airplanes By ID, returns "NULL" if inputted Id not found.
	@GetMapping("/routes/airplane/read/id/{id}")
	public Optional<Airplane> getAirplanesById(@PathVariable Integer id) {
		Optional<Airplane> airplanes = airplaneService.findAirplaneById(id);
		return airplanes;
	}

	
	//Update Airplane By ID
	@PutMapping("/routes/airplane/update/id/capacity/{id}/{capacity}")
	public String updateAirplaneById(@PathVariable Integer id, @PathVariable Integer capacity) {
		airplaneService.updateAirplaneById(id, capacity);
		return "Airplane Successfully Upated!";
	}



	// Delete Airplane
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

	// Read All Flights
	@GetMapping("/routes/flight/read")
	public List<Flight> getFlights() {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlights();
		return flights;
	}


	// Read Flights by Route ID 
	@GetMapping("/routes/flight/read/route_id/{routeId}")
	public List<Flight> getFlightsByRouteId(@PathVariable Integer routeId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByRouteId(routeId);
		return flights;
	}


	// Read Flights by Airplane ID
	@GetMapping("/routes/flight/read/airplane_id/{airplaneId}")
	public List<Flight> getFlightsByAirplaneId(@PathVariable Integer airplaneId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByAirplaneId(airplaneId);
		return flights;
	}
	
	// Read Flights by Date Time 
	@GetMapping("/routes/flight/read/date_time/{dateTime}")
	public List<Flight> getFlightsByDateTime(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDateTime(dateTime);
		return flights;
	}


	//Update Whole Flight by Flight ID
	@PutMapping("/routes/flight/update")
	public String updateFlight(@RequestBody Flight flight) {
		flightService.updateFlight(flight);
		return "Flight Successfully Upated!";
	}
	
	//Update Route ID by Flight ID
	@PutMapping("/routes/flight/update/flight_id/route_id/{id}/{routeId}")
	public String updateRouteIdByFlightId(@PathVariable Integer id, @PathVariable Integer routeId) {
		flightService.updateRouteIdByFlightId(id, routeId);
		return "Route ID Successfully Upated!";
	}
	
	//Update Airplane ID by Flight ID
	@PutMapping("/routes/flight/update/flight_id/airplane_id/{id}/{airplaneId}")
	public String updateAirplaneIdByFlightId(@PathVariable Integer id, @PathVariable Integer airplaneId) {
		flightService.updateAirplaneIdByFlightId(id, airplaneId);
		return "Airplane ID Successfully Upated!";
	}
	
	
	//Update Departure Date Time by Flight ID
	@PutMapping("/routes/flight/update/flight_id/departure_time/{id}/{dateTime}")
	public String updateDateTimeByFlightId(@PathVariable Integer id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
		flightService.updateDateTimeByFlightId(id, dateTime);
		return "Departure Date Time Successfully Upated!";
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
	
	// Delete By Airplane ID
	@DeleteMapping("/routes/flight/delete/date_time/{dateTime}")
	public String deleteFlightByDateTime(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
		flightService.deleteByDateTime(dateTime);
		return "Flight Deleted!";
	}
}
