package com.testspringboot.gestionhospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testspringboot.gestionhospital.models.Patient;
import com.testspringboot.gestionhospital.models.Personne;
import com.testspringboot.gestionhospital.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Patient>> getPatients() {
		try {
			List<Patient> _pat = patService.getPatients();
			return new ResponseEntity<List<Patient>>(_pat, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		try {
			Patient _pat = patService.getPatientById(id);
			if (_pat != null) {
				return new ResponseEntity<Patient>(_pat, HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// UPDATE MEDECIN !!
	@PostMapping(path = "/")
	public ResponseEntity<Personne> savePatient(@Valid @RequestBody Patient _pat) {
		try {
			return new ResponseEntity<>(patService.savePatient(_pat), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Patient> updatePatient(@Valid @PathVariable Long id, @RequestBody Patient _pat) {
		try {
			if (_pat != null) {
				return new ResponseEntity<Patient>(patService.updatePatient(id, _pat), HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteByID(@PathVariable Long id) {
		patService.deleteByID(id);
	}
	
	@DeleteMapping(path = "/")
	public void deleteAll() {
		patService.deleteAll();
	}
}
