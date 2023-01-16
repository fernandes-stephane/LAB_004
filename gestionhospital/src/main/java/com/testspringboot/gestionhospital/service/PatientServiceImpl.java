package com.testspringboot.gestionhospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringboot.gestionhospital.DAO.PatientDAO;
import com.testspringboot.gestionhospital.models.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patDAO;
	
	@Override
	public List<Patient> getPatients() {
		List<Patient> _pat = (List<Patient>)patDAO.findAll();
		if (!_pat.isEmpty()) {
			return _pat;
		} else {
			return null;
		}
	}

	@Override
	public Patient getPatientById(Long id) {
		Optional<Patient> pat = patDAO.findById(id);
		if (pat.isPresent()) {
			return pat.get();
		} else {
			return null;
		}
	}

	@Override
	public Patient savePatient(Patient patient) {
		Patient _pat = new Patient();
		_pat.setName(patient.getName());
		_pat.setFirstName(patient.getFirstName());
		_pat.setBitrhDate(patient.getBitrhDate());
		_pat.setMutuelle(patient.getMutuelle());
		_pat.setAdresse(patient.getAdresse());
		_pat.setNumTel(patient.getNumTel());
		_pat.setMail(patient.getMail());
		patDAO.save(_pat);
		return _pat;
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> result = patDAO.findById(id);
		if (result.isPresent()) {
			Patient _pat = result.get();
			_pat.setName(patient.getName());
			_pat.setFirstName(patient.getFirstName());
			_pat.setBitrhDate(patient.getBitrhDate());
			_pat.setMutuelle(patient.getMutuelle());
			_pat.setAdresse(patient.getAdresse());
			_pat.setNumTel(patient.getNumTel());
			_pat.setMail(patient.getMail());
			patDAO.save(_pat);
			return _pat;
		} else {
			return null;
		}
	}

	@Override
	public void deleteByID(Long id) {
		Optional<Patient> _pat = patDAO.findById(id);
		if (_pat.isPresent()) {
			patDAO.delete(_pat.get());
		}
	}

	@Override
	public void deleteAll() {
		patDAO.deleteAll();
	}

}
