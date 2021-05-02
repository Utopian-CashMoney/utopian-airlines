/**
 * 
 */
package com.smoothstack.utopiaairlines.controllers;

import com.smoothstack.utopiaairlines.entities.Route;
import com.smoothstack.utopiaairlines.services.RouteAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
 * Controller for administrator route management
 * @author Josten Asercion
 */

@RestController
@RequestMapping("/admin/route")
public class AdminRoute {
	@Autowired
	private RouteAdminService routeAdminService;

	@PostMapping("/create")
	public String create(@RequestBody Route route) {
		try {
			route = routeAdminService.create(route);
			return (String.format("Route created with ID %d", route.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			return ("Failed to create route");
		}
	}

	@GetMapping("/all")
	public List<Route> getAll() {
		try {
			return routeAdminService.all();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/id/{id}")
	public Route searchById(@PathVariable("id") Integer id) {
		try {
			return routeAdminService.searchById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/origin/{origin}")
	public List<Route> searchByOrigin(@PathVariable("origin") String origin) {
		try {
			return routeAdminService.searchByOrigin(origin);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/destination/{destination}")
	public List<Route> searchByDestination(@PathVariable("destination") String destination) {
		try {
			return routeAdminService.searchByDestination(destination);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Put update here. FINISH AFTER AIRPORT IS DONE.
	 * 
	 * @PutMapping("/update/{id}/origin/{origin}") public String
	 * update(@PathVariable("id") Integer id, @PathVariable("origin") ) { return
	 * "Work in progress."; }
	 */

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		try {
			routeAdminService.deleteRoute(id);
			return "Successfully deleted route.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to delete route.";
		}
	}
}