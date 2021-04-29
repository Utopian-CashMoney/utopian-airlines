package com.smoothstack.utopiaairlines.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smoothstack.utopiaairlines.entities.Flight;

@Repository
@Transactional
public interface FlightDao extends JpaRepository<Flight, Integer> {
	
	List<Flight> findByRouteId(Integer id);
	List<Flight> findByAirplaneId(Integer id);

}
