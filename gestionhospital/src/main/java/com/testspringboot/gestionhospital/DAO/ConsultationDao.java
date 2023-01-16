package com.testspringboot.gestionhospital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testspringboot.gestionhospital.models.Consultation;


@Repository
public interface ConsultationDao extends CrudRepository<Consultation, Long>{

}
