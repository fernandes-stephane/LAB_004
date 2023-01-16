package com.testspringboot.gestionhospital.service;

import java.util.List;

import com.testspringboot.gestionhospital.models.Personne;

public interface PersonneService {
	
	List<Personne> getPersonnes();

	void deleteByID(Long id);
	
	Personne updateByID(Long id, Personne personne);
}
