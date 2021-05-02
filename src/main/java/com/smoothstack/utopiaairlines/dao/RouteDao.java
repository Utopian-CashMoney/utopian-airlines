package com.smoothstack.utopiaairlines.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smoothstack.utopiaairlines.entities.Route;

@Repository
@Transactional
public interface RouteDao extends JpaRepository<Route, Integer> {
	
	Optional<Route> findById(Integer id);
	List <Route> findByOriginLike(String origin);
	List <Route> findByDestinationLike(String destination);

}
