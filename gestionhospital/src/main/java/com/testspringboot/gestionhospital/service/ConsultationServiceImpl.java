package com.testspringboot.gestionhospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringboot.gestionhospital.DAO.ConsultationDao;
import com.testspringboot.gestionhospital.models.Consultation;

@Service
public class ConsultationServiceImpl implements ConsulatationService{

	@Autowired
	private ConsultationDao consDAO;
	
	@Override
	public List<Consultation> getConsulations() {
		List<Consultation> _cons = (List<Consultation>)consDAO.findAll();
		
		if (!_cons.isEmpty()) {
			return _cons;
		} else {
			return null;
		}
	}

	@Override
	public Consultation getConsulationByID(Long id) {
		Optional<Consultation> _cons = consDAO.findById(id);
		if (_cons.isPresent()) {
			return _cons.get();
		} else {
			return null;
		}
	}

	@Override
	public Consultation saveConsulation(Consultation Cons) {
		Consultation _cons = new Consultation();
		_cons.setType(Cons.getType());
		_cons.setTarif(Cons.getTarif());
		consDAO.save(_cons);
		return _cons;
	}

	@Override
	public Consultation updateConsulation(Long id, Consultation Cons) {
		Optional<Consultation> result = consDAO.findById(id);
		if (result.isPresent()) {
			Consultation _cons = result.get();
			_cons.setType(Cons.getType());
			_cons.setTarif(Cons.getTarif());
			consDAO.save(_cons);
			return _cons;
		} else {
			return null;
		}
	}

	@Override
	public void deleteByID(Long id) {
		Optional<Consultation> _cons = consDAO.findById(id);
		if (_cons.isPresent()) {
			consDAO.delete(_cons.get());
		}
	}

	@Override
	public void deleteAll() {
		consDAO.deleteAll();
	}
	

}
