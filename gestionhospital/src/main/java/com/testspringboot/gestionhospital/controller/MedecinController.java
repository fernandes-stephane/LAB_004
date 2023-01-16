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

import com.testspringboot.gestionhospital.models.Medecin;
import com.testspringboot.gestionhospital.service.MedecinService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/medecin")
public class MedecinController {
	
	@Autowired //(required=true)
	private MedecinService medService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Medecin>> getMedecins() {	
		try {
			List<Medecin> _med = medService.getMedecins();
			return new ResponseEntity<>(_med, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Medecin> saveMedecin(@Valid @RequestBody Medecin _med) {
		try {
			return new ResponseEntity<>(medService.saveMedecin(_med), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Medecin> getMedecinByID(@Valid @PathVariable Long id) {
		try {
			Medecin _med = medService.getMedecinByID(id);
			if (_med != null) {
				return new ResponseEntity<Medecin>(_med, HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Medecin> updateMedecin(@Valid @PathVariable Long id, @RequestBody Medecin _med) {
		try {
			if (_med != null) {
				return new ResponseEntity<Medecin>(medService.updateMedecin(id, _med), HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteByID(@PathVariable Long id) {
		medService.deleteByID(id);
	}
	
	@DeleteMapping(path = "/")
	public void deleteAll() {
		medService.deleteAll();
	}
}
