package com.smoothstack.utopiaairlines.service;

import java.util.List;

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
	public List<Airplane> getAllAirplanes(){
		List<Airplane> airplanes = airplaneDao.findAll();
		return airplanes;
	}
	
	
	// Update airplane
	public void updateAirplane(Airplane airplane){
		//airplaneDao.save(airplane); 
		
		airplaneDao.findById(airplane.getId());
		airplaneDao.save(airplane);
	    
	}
	
	
	// Delete airplane
	public void deleteAirplane(Integer id){
		airplaneDao.deleteById(id);
	}
	

}
