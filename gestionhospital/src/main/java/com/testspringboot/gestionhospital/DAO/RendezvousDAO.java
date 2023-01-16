package com.testspringboot.gestionhospital.DAO;

//import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testspringboot.gestionhospital.models.Medecin;
import com.testspringboot.gestionhospital.models.Patient;
import com.testspringboot.gestionhospital.models.Rendezvous;

@Repository
public interface RendezvousDAO extends CrudRepository<Rendezvous, Long>{
	List<Rendezvous>  findByMedecin(Medecin medecin);
	List<Rendezvous> findByPatient(Patient patient);
	// List<Rendezvous> findByDate(Date date); A rajouter plus tard si j'ai le temps
}
