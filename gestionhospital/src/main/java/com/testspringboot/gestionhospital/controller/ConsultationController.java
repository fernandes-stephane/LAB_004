package com.testspringboot.gestionhospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testspringboot.gestionhospital.models.Consultation;
import com.testspringboot.gestionhospital.service.ConsulatationService;

@RestController
@RequestMapping(path = "/api/consultation")
public class ConsultationController {
	
	@Autowired
	private ConsulatationService tpService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Consultation>> getConsulations() {	
		try {
			List<Consultation> _cons = tpService.getConsulations();
			return new ResponseEntity<>(_cons, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Consultation> getTypeConsulationByID(@PathVariable Long id) {
		try {
			Consultation _cons = tpService.getConsulationByID(id);
			if (_cons != null) {
				return new ResponseEntity<Consultation>(_cons, HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Consultation> saveConsulation(@RequestBody Consultation _cons) {
		try {
			return new ResponseEntity<>(tpService.saveConsulation(_cons), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Consultation> updateConsulation(@PathVariable Long id, @RequestBody Consultation _cons) {
		try {
			if (_cons != null) {
				return new ResponseEntity<Consultation>(tpService.updateConsulation(id, _cons), HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@DeleteMapping(path = "/{id}")
	//public void deleteByID(@PathVariable Long id) {
	//	tpService.deleteByID(id);
	//}
	
	//@DeleteMapping(path = "/")
	//public void deleteAll() {
	//	tpService.deleteAll();
	//}
}
