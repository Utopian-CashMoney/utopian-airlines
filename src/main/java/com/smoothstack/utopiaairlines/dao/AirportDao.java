package com.smoothstack.utopiaairlines.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopiaairlines.entities.Airport;


@Repository
public interface AirportDao extends JpaRepository<Airport, String> {

}
