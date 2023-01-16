package com.testspringboot.gestionhospital.service;

import java.util.List;

import com.testspringboot.gestionhospital.models.Patient;

public interface PatientService {
	
	// contrat avec Service impl
	List<Patient> getPatients();
	
	Patient getPatientById(Long id);
	
	Patient savePatient(Patient patient);
	
	Patient updatePatient(Long id, Patient patient);
	
	void deleteByID(Long id);
	
	void deleteAll();

}
