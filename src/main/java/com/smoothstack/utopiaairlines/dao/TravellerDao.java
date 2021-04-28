package com.smoothstack.utopiaairlines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smoothstack.utopiaairlines.entities.Traveller;

@Repository
public interface TravellerDao extends JpaRepository<Traveller, Integer> {

}