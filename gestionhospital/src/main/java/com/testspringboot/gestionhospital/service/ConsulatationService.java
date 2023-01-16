package com.testspringboot.gestionhospital.service;

import java.util.List;

import com.testspringboot.gestionhospital.models.Consultation;

public interface ConsulatationService {

	List<Consultation> getConsulations();
	
	Consultation getConsulationByID(Long id);
	
	Consultation saveConsulation(Consultation consultation);
	
	Consultation updateConsulation(Long id, Consultation consultation);
	
	void deleteByID(Long id);
	
	void deleteAll();
}
