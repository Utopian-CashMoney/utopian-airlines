package com.smoothstack.utopiaairlines.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/routes/airplane/read/id")	
	public Optional<Airplane> getAirplanesById(@RequestParam ("id") Integer id) {
		Optional<Airplane> airplanes = airplaneService.findAirplaneById(id);
		return airplanes;
	}

	
	//Update Airplane By ID
	@PutMapping("/routes/airplane/update/id/capacity")
	public String updateAirplaneById(@RequestParam ("id") Integer id, @RequestParam ("cap") Integer capacity) {
		airplaneService.updateAirplaneById(id, capacity);
		return "Airplane Successfully Upated!";
	}



	// Delete Airplane
	@DeleteMapping("/routes/airplane/delete")
	public String deleteAirplane(@RequestParam ("id") Integer id) {
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


	// HEREEEEEEEEEEEEEEEEE
	
	// Read Flights by Route ID 
	@GetMapping("/routes/flight/read/route_id")
	public List<Flight> getFlightsByRouteId(@RequestParam ("routeid") Integer routeId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByRouteId(routeId);
		return flights;
	}


	// Read Flights by Airplane ID
	@GetMapping("/routes/flight/read/airplane_id")
	public List<Flight> getFlightsByAirplaneId(@RequestParam ("airplaneid") Integer airplaneId) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByAirplaneId(airplaneId);
		return flights;
	}
	
	/*// Read Flights by Date Time 
	@GetMapping("/routes/flight/read/date_time")
	public List<Flight> getFlightsByDateTime(@RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDateTime(dateTime);
		return flights;
	}*/
	
	
	// Read Flights by Date 
	@GetMapping("/routes/flight/read/date")
	public List<Flight> getFlightsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDate(date);
		return flights;													
	}
	
	
	// Read all the Flights flying before the provided date
	@GetMapping("/routes/flight/read/datebefore")
	public List<Flight> getFlightsByDateBefore(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDateBefore(date);
		return flights;													
	}
	
	
	// Read all the Flights flying after the provided date
	@GetMapping("/routes/flight/read/dateafter")
	public List<Flight> getFlightsByDateAfter(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDateAfter(date);
		return flights;													
	}
	
	
	// Read all the Flights flying between the provided date
	@GetMapping("/routes/flight/read/datebetween")
	public List<Flight> getFlightsByDateBetween(@RequestParam("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @RequestParam("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {
		List<Flight> flights = new ArrayList<>();
		flights = flightService.findFlightsByDateBetween(dateStart, dateEnd);
		return flights;													
	}
	


	//Update Whole Flight by providing body
	@PutMapping("/routes/flight/update")
	public String updateFlight(@RequestBody Flight flight) {
		flightService.updateFlight(flight);
		return "Flight Successfully Upated!";
	}
	
	//Update Route ID by Flight ID
	@PutMapping("/routes/flight/update/flight_id/route_id")
	public String updateRouteIdByFlightId(@RequestParam("id") Integer id, @RequestParam("routeid") Integer routeId) {
		flightService.updateRouteIdByFlightId(id, routeId);
		return "Route ID Successfully Upated!";
	}
	
	//Update Airplane ID by Flight ID
	@PutMapping("/routes/flight/update/flight_id/airplane_id")
	public String updateAirplaneIdByFlightId(@RequestParam("id") Integer id, @RequestParam("airplaneid") Integer airplaneId) {
		flightService.updateAirplaneIdByFlightId(id, airplaneId);
		return "Airplane ID Successfully Upated!";
	}
	
	
	//Update Departure Date Time by Flight ID
	@PutMapping("/routes/flight/update/flight_id/departure_time")
	public String updateDateTimeByFlightId(@RequestParam("id") Integer id, @RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
		flightService.updateDateTimeByFlightId(id, dateTime);
		return "Departure Date Time Successfully Upated!";
	}



	//Delete by ID
	@DeleteMapping("/routes/flight/delete")
	public String deleteFlight(@RequestParam("id") Integer id) {
		flightService.deleteFlight(id);
		return "Flight Deleted!";
	}


	// Delete By Route ID
	@DeleteMapping("/routes/flight/delete/route_id")
	public String deleteFlightByRouteId(@RequestParam("id") Integer id) {
		flightService.deleteByRouteId(id);
		return "Flight Deleted!";
	}

	// Delete By Airplane ID
	@DeleteMapping("/routes/flight/delete/airplane_id")
	public String deleteFlightByAirplaneId(@RequestParam("id") Integer id) {
		flightService.deleteByAirplaneId(id);
		return "Flight Deleted!";
	}
	
	
	// Delete By Date
	@DeleteMapping("/routes/flight/delete/date")
	public String deleteFlightByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		flightService.deleteByDate(date);
		return "Flight Deleted!";
	}
}
