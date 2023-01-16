package com.testspringboot.gestionhospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringboot.gestionhospital.DAO.PersonneDAO;
import com.testspringboot.gestionhospital.models.Personne;

@Service
public class PersonneServiceImpl implements PersonneService{
	
	@Autowired
	private PersonneDAO perDAO;
	
	@Override
	public List<Personne> getPersonnes() {
		
		List<Personne> _per = (List<Personne>) perDAO.findAll();
		if(!_per.isEmpty()) {
			return _per;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteByID(Long id) {
		Optional<Personne> _per = perDAO.findById(id);
		if (_per.isPresent()) {
			perDAO.delete(_per.get());
		}	
	}

	@Override
	public Personne updateByID(Long id, Personne personne) {
		Optional<Personne> result = perDAO.findById(id);
		if (result.isPresent()) {
			Personne _per = result.get();
			_per.setFirstName(personne.getFirstName());
			_per.setName(personne.getName());
			perDAO.save(_per);
			return _per;
		} else {
			return null;
		}
	}
	
	
	
}
