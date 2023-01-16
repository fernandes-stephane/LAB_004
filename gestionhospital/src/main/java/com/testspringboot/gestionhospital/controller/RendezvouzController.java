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


import com.testspringboot.gestionhospital.models.Rendezvous;
import com.testspringboot.gestionhospital.service.RendezvousService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/rendezvous")
public class RendezvouzController {
	
	@Autowired
	private RendezvousService rdvService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Rendezvous>> getRendezvous() {	
		try {
			List<Rendezvous> _rdvList = rdvService.getRendezvous();
			return new ResponseEntity<>(_rdvList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Rendezvous> getRendezvousByID(@PathVariable Long id) {
		try {
			Rendezvous _rdv = rdvService.getRendezvousByID(id);
			if (_rdv != null) {
				return new ResponseEntity<Rendezvous>(_rdv, HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/medecin/{medID}")
	public ResponseEntity<List<Rendezvous>> getRendezvousByMedecin(@PathVariable Long medID) {
		try {
			List<Rendezvous> _rdvList = rdvService.getByMedecin(medID);
			if (_rdvList != null) {
				return new ResponseEntity<List<Rendezvous>>(_rdvList, HttpStatus.OK);
			}return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/patient/{patID}")
	public ResponseEntity<List<Rendezvous>> getRendezvousByPatient(@PathVariable Long patID) {
		try {
			List<Rendezvous> _rdvList = rdvService.getByPatient(patID);
			if (_rdvList != null) {
				return new ResponseEntity<List<Rendezvous>>(_rdvList, HttpStatus.OK);
			}return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Rendezvous> saveRendezvou(@Valid @RequestBody Rendezvous _rdv) {
		try {
			return new ResponseEntity<>(rdvService.saveRendezvous(_rdv), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Rendezvous> updateRendezvou(@Valid @PathVariable Long id, @RequestBody Rendezvous _rdv) {
		try {
			if (_rdv != null) {
				return new ResponseEntity<Rendezvous>(rdvService.updateRendezvous(id, _rdv), HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteByID(@PathVariable Long id) {
		rdvService.deleteByID(id);
	}
	
	@DeleteMapping(path = "/")
	public void deleteAll() {
		rdvService.deleteAll();
	}

}
