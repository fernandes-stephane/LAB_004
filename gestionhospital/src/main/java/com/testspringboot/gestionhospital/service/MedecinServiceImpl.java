package com.testspringboot.gestionhospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringboot.gestionhospital.DAO.MedecinDAO;
import com.testspringboot.gestionhospital.models.Medecin;

@Service
public class MedecinServiceImpl implements MedecinService{
	
	@Autowired
	private MedecinDAO medDAO; 

	@Override
	public List<Medecin> getMedecins() {
		List<Medecin> _med = (List<Medecin>)medDAO.findAll();
		if (!_med.isEmpty()) {
			return _med;
		} else {
			return null;
		}
	}

	@Override
	public Medecin saveMedecin(Medecin med) {
		Medecin _med = new Medecin();
		_med.setName(med.getName());
		_med.setFirstName(med.getFirstName());
		_med.setBitrhDate(med.getBitrhDate());
		_med.setSpecialite(med.getSpecialite());
		_med.setAdresse(med.getAdresse());
		_med.setNumTel(med.getNumTel());
		_med.setMail(med.getMail());
		medDAO.save(_med);
		return _med;
	}

	@Override
	public Medecin getMedecinByID(Long id) {
		Optional<Medecin> med = medDAO.findById(id);
		if (med.isPresent()) {
			return med.get();
		} else {
			return null;
		}
	}
	
	@Override
	public Medecin updateMedecin(Long id, Medecin med) {
		Optional<Medecin> result = medDAO.findById(id);
		if (result.isPresent()) {
			Medecin _med = result.get();
			_med.setName(med.getName());
			_med.setFirstName(med.getFirstName());
			_med.setBitrhDate(med.getBitrhDate());
			_med.setSpecialite(med.getSpecialite());
			_med.setAdresse(med.getAdresse());
			_med.setNumTel(med.getNumTel());
			_med.setMail(med.getMail());
			medDAO.save(_med);
			return _med;
		} else {
			return null;
		}
	}

	@Override
	public void deleteByID(Long id) {
		Optional<Medecin> _med = medDAO.findById(id);
		if (_med.isPresent()) {
			medDAO.delete(_med.get());
		}
	}

	@Override
	public void deleteAll() {
		medDAO.deleteAll();
	}

}
