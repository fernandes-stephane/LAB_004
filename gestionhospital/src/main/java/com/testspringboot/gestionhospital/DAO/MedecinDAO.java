package com.testspringboot.gestionhospital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testspringboot.gestionhospital.models.Medecin;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{

}
