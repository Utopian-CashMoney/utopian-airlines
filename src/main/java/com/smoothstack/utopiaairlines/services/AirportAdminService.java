package com.smoothstack.utopiaairlines.services;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smoothstack.utopiaairlines.dao.AirportDao;
import com.smoothstack.utopiaairlines.entities.Airport;

@Service
public class AirportAdminService {

	@Autowired
	private AirportDao airportDAO;

	/**
	 * Create a new airport
	 * 
	 * @author Josten Asercion
	 * @param airport the new airport to be created
	 */
	public Airport create(Airport airport) {
		return airportDAO.save(airport);
	}

	/**
	 * Get all Airports in DB
	 * 
	 * @author Josten Asercion
	 * @return List of all airports
	 */
	public List<Airport> all() {
		return airportDAO.findAll();
	}

	/**
	 * Return a airport specified by an id
	 * 
	 * @author Josten Asercion
	 * @param IataId the IataId
	 * @return Airport specified by the id, null if DNE
	 */

	public Airport searchByIataId(String IataId) {
		return airportDAO.getById(IataId);
	}

	/**
	 * Return a airport specified by an city
	 * 
	 * @author Josten Asercion
	 * @param city the city
	 * @return Airport specified by the city, null if DNE
	 */

	public List<Airport> searchByCity(String city) {
		return airportDAO.findByCityLike(String.format("%%s%", city));
	}

	/**
	 * Update the city of the airport by the iata id
	 * 
	 * @author Josten Asercion
	 * @param iataId the iata id of the airport
	 * @param city   the new city to assign to the airport
	 * @return true if one matching iata id is found, false if none are found
	 */
	public Boolean updateCityById(String iataId, String city) {

		if (this.searchByIataId(iataId) != null) {
			Airport airport = this.searchByIataId(iataId);
			airport.setCity(city);

			airportDAO.save(airport);
			return true;
		} else
			return false;
	}

	/**
	 * Delete the airport by an id
	 * 
	 * @author Josten Asercion
	 * @param id the iata id for the airport to be deleted
	 */
	public void deleteAirport(String iataId) {
		Airport airport = this.searchByIataId(iataId);
		airportDAO.delete(airport);
	}
}
