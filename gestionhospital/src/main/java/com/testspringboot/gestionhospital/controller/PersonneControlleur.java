package com.testspringboot.gestionhospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testspringboot.gestionhospital.models.Personne;
import com.testspringboot.gestionhospital.service.PersonneService;

@RestController
@RequestMapping(path = "/api/personne")
public class PersonneControlleur {
	
	@Autowired
	private PersonneService perService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Personne>> getPersonnes(){
		
		try {
			List<Personne> _per =  perService.getPersonnes();
			if(!_per.isEmpty()) {
				return new ResponseEntity<>(_per, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
