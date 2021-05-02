/**
 * 
 */
package com.smoothstack.utopiaairlines.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.utopiaairlines.dao.RouteDao;
import com.smoothstack.utopiaairlines.entities.Airport;
import com.smoothstack.utopiaairlines.entities.Route;

@Service
public class RouteAdminService {

	@Autowired
	private RouteDao routeDAO;

	/**
	 * Create a new route
	 * 
	 * @author Josten Asercion
	 * @param route the new route to be created
	 */
	public Route create(Route route) {
		return routeDAO.save(route);
	}

	/**
	 * Get all Routes in DB
	 * 
	 * @author Josten Asercion
	 * @return List of all routes
	 */
	public List<Route> all() {
		return routeDAO.findAll();
	}

	/**
	 * Return a route specified by an id
	 * 
	 * @author Josten Asercion
	 * @param id the id
	 * @return Route specified by the id, null if DNE
	 */
	public Optional<Route> searchById(Integer id) {
		return routeDAO.findById(id);
	}

	/**
	 * Return a list of routes with a specified origin
	 * 
	 * @author Josten Asercion
	 * @param origin the origin to search for
	 * @return list of routes of the specified origin
	 */
	public List<Route> searchByOrigin(String origin) {
		return routeDAO.findByOriginLike(origin);
	}

	/**
	 * Return a list of routes with a specified destination
	 * 
	 * @author Josten Asercion
	 * @param destination the destination to search for
	 * @return list of routes of the specified destination
	 */
	public List<Route> searchByDestination(String destination) {
		return routeDAO.findByDestinationLike(destination);
	}

	
	/**
	 * Update the origin airport of the route by an id
	 * 
	 * @author Josten Asercion
	 * @param airport the new origin airport
	 * @param iata    the new iata code for the route origin
	 */
	public void updateOriginById(Integer id, Airport airport) {
		try {
			Optional<Route> routes = this.searchById(id);
			Route route = routes.get();
			route.setOrigin(airport);

			routeDAO.save(route);
		} catch (Exception e) {
			Optional.empty();
		}
	}

	/**
	 * Update the destination airport of the route by an id
	 * 
	 * @author Josten Asercion
	 * @param airport the new destination airport
	 * @param iata    the new iata code for the route destination
	 */
	public void updateDestinationById(Integer id, Airport airport) {
		try {
			Optional<Route> routes = this.searchById(id);
			Route route = routes.get();
			route.setDestination(airport);

			routeDAO.save(route);
		} catch (Exception e) {
			Optional.empty();
		}
	}

	/**
	 * Delete the route by an id
	 * 
	 * @author Josten Asercion
	 * @param id the id for the route to be deleted
	 */
	public void deleteRoute(Integer id) {
		routeDAO.deleteById(id);
	}
}
