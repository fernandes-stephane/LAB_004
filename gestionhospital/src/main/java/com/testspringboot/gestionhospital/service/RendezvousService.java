package com.testspringboot.gestionhospital.service;

import java.util.List;

import com.testspringboot.gestionhospital.models.Rendezvous;

public interface RendezvousService {
	
	List<Rendezvous> getRendezvous();
	
	List<Rendezvous> getByMedecin(Long id); // à remplacer: id par nom medecin ou autre identifiant unique //
	
	List<Rendezvous> getByPatient(Long id); // à remplacer: id par mail patient ou autre identifiant unique //
	
	Rendezvous getRendezvousByID(Long id);
	
	Rendezvous saveRendezvous(Rendezvous rdv);
	
	Rendezvous updateRendezvous(Long id, Rendezvous rdv);
	
	void deleteByID(Long id);
	
	void deleteAll();
}
