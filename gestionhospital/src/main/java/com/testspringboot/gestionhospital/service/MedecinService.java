package com.testspringboot.gestionhospital.service;

import java.util.List;

import com.testspringboot.gestionhospital.models.Medecin;

public interface MedecinService {
	
	List<Medecin> getMedecins();
	
	Medecin getMedecinByID(Long id);
	
	Medecin saveMedecin(Medecin med);
	
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteByID(Long id);
	
	void deleteAll();
}
