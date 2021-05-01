package com.smoothstack.utopiaairlines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.utopiaairlines.dao.AirplaneDao;
import com.smoothstack.utopiaairlines.entities.Airplane;
import com.smoothstack.utopiaairlines.entities.Flight;


@Service
public class AirplaneService {

	@Autowired
	AirplaneDao airplaneDao;

	Airplane airplane;
	Flight flight;

	// Add Airplane
	public void addAirplane(Airplane airplane)  
	{    
		airplaneDao.save(airplane);    
	}  



	// Read all airplanes
	public List<Airplane> findAirplanes(){
		List<Airplane> airplanes = airplaneDao.findAll();
		return airplanes;
	}

	// Read airplane by ID
	public Optional<Airplane> findAirplaneById(Integer id){
		Optional<Airplane> airplanes = airplaneDao.findById(id);
		return airplanes;
	}


	// Update airplane By Id
	public void updateAirplaneById(Integer id, Integer capacity){
		try {
			Optional<Airplane> airplanes = findAirplaneById(id);
			Airplane airplane = airplanes.get();
			airplane.setCapacity(capacity);

			airplaneDao.save(airplane);
		} catch (Exception e) {
			Optional.empty();
		}

	}


	// Delete airplane
	public void deleteAirplane(Integer id){
		airplaneDao.deleteById(id);
	}


}
