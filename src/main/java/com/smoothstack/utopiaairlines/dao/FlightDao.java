package com.smoothstack.utopiaairlines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smoothstack.utopiaairlines.entities.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

}
