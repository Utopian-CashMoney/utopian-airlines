package com.smoothstack.utopiaairlines.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopiaairlines.entities.Airport;

@Repository
@Transactional
public interface AirportDao extends JpaRepository<Airport, String> {

	List<Airport> findByIataId(String iataId);

	List<Airport> findByCityLike(String city);

	Airport getById(String iataId);
}
