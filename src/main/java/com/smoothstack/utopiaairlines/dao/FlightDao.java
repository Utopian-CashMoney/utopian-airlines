package com.smoothstack.utopiaairlines.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopiaairlines.entities.Flight;

@Repository
@Transactional
public interface FlightDao extends JpaRepository<Flight, Integer> {
	
	List<Flight> findByRouteId(Integer id);
	List<Flight> findByAirplaneId(Integer id);
		
	@Query(
			  value = "SELECT * FROM flight f WHERE f.departure_time = ?", 
			  nativeQuery = true)
	List<Flight> findByDT(LocalDateTime dateTime);
	
	Optional<Flight> findById(Integer id);

}
