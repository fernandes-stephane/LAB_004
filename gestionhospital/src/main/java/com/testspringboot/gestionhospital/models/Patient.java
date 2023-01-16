package com.testspringboot.gestionhospital.models;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient extends Personne{
	
	private static final long serialVersionUID = 1L;
	
	@Column // ici on prends par defaut le name mutuelle
	private Boolean mutuelle;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Collection<Rendezvous> rdv;
	
	// Constructeur
	public Patient() {}
	public Patient(String firstName, String name, Date bitrhDate,
			String numTel, String adresse, String mail, Boolean mutuelle) {
		super(firstName, name, bitrhDate, numTel, adresse, mail);
		this.mutuelle = mutuelle;
	}

	// Getters & Setters
	public Boolean getMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(Boolean mutuelle) {
		this.mutuelle = mutuelle;
	}	
	
	@JsonIgnore
	public Collection<Rendezvous> getRendezvous() {
		return rdv;
	}
	
}
