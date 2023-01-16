package com.testspringboot.gestionhospital.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultation")
public class Consultation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "tarif")
	private Long tarif;

	// Constructeur
	public Consultation() {}
	public Consultation(String type, Long tarif) {
		this.type = type;
		this.tarif = tarif;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getTarif() {
		return tarif;
	}
	public void setTarif(Long tarif) {
		this.tarif = tarif;
	}

}
