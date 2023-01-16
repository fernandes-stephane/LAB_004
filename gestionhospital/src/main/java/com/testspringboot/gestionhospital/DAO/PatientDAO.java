package com.testspringboot.gestionhospital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testspringboot.gestionhospital.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long>{

}
