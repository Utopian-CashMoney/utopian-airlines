package com.smoothstack.utopiaairlines.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smoothstack.utopiaairlines.entities.Route;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer> {
	
	Optional<Route> findById(Integer id);

}
