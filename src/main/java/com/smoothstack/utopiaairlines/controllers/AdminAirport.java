package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Airport;
import com.smoothstack.utopiaairlines.services.AirportAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller for administrator airport management
 * @author Josten Asercion
 */

@RestController
@RequestMapping("/admin/airport")
public class AdminAirport {
	@Autowired
	private AirportAdminService airportAdminService;

	@PostMapping("/create")
	public String create(@RequestBody Airport airport) {
		try {
			airport = airportAdminService.create(airport);
			return ("Airport created.");
		} catch (Exception e) {
			e.printStackTrace();
			return ("Failed to create airport");
		}
	}

	@GetMapping("/all")
	public List<Airport> getAll() {
		try {
			return airportAdminService.all();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/iataId/{id}")
	public Airport searchById(@PathVariable("id") String id) {
		try {
			return airportAdminService.searchByIataId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/city/{city}")
	public List<Airport> searchByCity(@PathVariable("city") String city) {
		try {
			return airportAdminService.searchByCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/update/{id}/{city}")
	public String updateCity(@PathVariable("id") String id, @PathVariable("city") String city) {
		try {
			airportAdminService.updateCityById(id, city);

			return "Successfully updated city.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to update city.";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		try {
			airportAdminService.deleteAirport(id);
			return "Successfully deleted airport.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to delete airport.";
		}
	}
}