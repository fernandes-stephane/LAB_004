package com.testspringboot.gestionhospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringboot.gestionhospital.DAO.ConsultationDao;
import com.testspringboot.gestionhospital.DAO.MedecinDAO;
import com.testspringboot.gestionhospital.DAO.PatientDAO;
import com.testspringboot.gestionhospital.DAO.RendezvousDAO;
import com.testspringboot.gestionhospital.models.Consultation;
import com.testspringboot.gestionhospital.models.Medecin;
import com.testspringboot.gestionhospital.models.Patient;
import com.testspringboot.gestionhospital.models.Rendezvous;

@Service
public class RendezvousServiceImpl implements RendezvousService{
	
	@Autowired
	private RendezvousDAO rdvDAO;
	
	@Autowired
	private MedecinDAO medDAO;
	
	@Autowired
	private PatientDAO patDAO;
	
	@Autowired
	private ConsultationDao consDAO;
	
	@Override
	public List<Rendezvous> getRendezvous() {
		List<Rendezvous> _rdvList = (List<Rendezvous>)rdvDAO.findAll();
		
		if (!_rdvList.isEmpty()) {
			return _rdvList;
		} else {
			return null;
		}
	}

	@Override
	public Rendezvous getRendezvousByID(Long id) {
		Optional<Rendezvous> _rdv = rdvDAO.findById(id);
		if (_rdv.isPresent()) {
			return _rdv.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Rendezvous> getByMedecin(Long medID) {
		Optional<Medecin> med = medDAO.findById(medID);
		if (med.isPresent()) {
			List<Rendezvous> _rdvList = rdvDAO.findByMedecin(med.get());
			if (!_rdvList.isEmpty()) {
				return _rdvList;
			}
		} return null;		
	}

	@Override
	public List<Rendezvous> getByPatient(Long patID) {
		Optional<Patient> pat = patDAO.findById(patID);
		if (pat.isPresent()) {
			List<Rendezvous> _rdvList = rdvDAO.findByPatient(pat.get());
			if (!_rdvList.isEmpty()) {
				return _rdvList;
			}
		} return null;

	}

	@Override
	public Rendezvous saveRendezvous(Rendezvous rdv) {
		Optional<Medecin> _med = medDAO.findById(rdv.getMedecin().getId());
		Optional<Patient> _pat = patDAO.findById(rdv.getPatient().getId());
		

		if (_med.isPresent() && _pat.isPresent()) {
			// On enregistre une nouvelle consultation
			// consDAO.save(rdv.getCons());
			
			Consultation _cons = new Consultation();
			_cons.setType(rdv.getCons().getType());
			_cons.setTarif(rdv.getCons().getTarif());
			consDAO.save(_cons);
			
			// On enregistre un rdv
			Rendezvous _rdv = new Rendezvous();
			_rdv.setDate(rdv.getDate());
			// A vrai dire je ne sais pas d'ou il retrouves l'id de _cons
			// Mais sa à l'air de bien marcher comme sa 
			// Sans avoir besoin d'aller chercher le dernier enregistrement idk why
			_rdv.setCons(_cons);
			_rdv.setMedecin(_med.get());
			_rdv.setPatient(_pat.get());
			rdvDAO.save(_rdv);
			return _rdv;
		}else {
			return null;
		}
	}

	@Override
	public Rendezvous updateRendezvous(Long id, Rendezvous rdv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(Long id) {
		Optional<Rendezvous> _rdv = rdvDAO.findById(id);
		if (_rdv.isPresent()) {
			rdvDAO.delete(_rdv.get());
		}
	}

	@Override
	public void deleteAll() {
		rdvDAO.deleteAll();
		
	}

}
