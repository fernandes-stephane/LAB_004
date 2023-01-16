package com.testspringboot.gestionhospital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testspringboot.gestionhospital.models.Personne;

@Repository
public interface PersonneDAO extends CrudRepository<Personne, Long>{
	
}
