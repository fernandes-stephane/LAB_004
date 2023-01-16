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
@Table(name="medecin")
public class Medecin extends Personne{
	
	private static final long serialVersionUID = 1L;
	
	@Column // on prends le name specialite par defaut
	private String specialite;
	
	@OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
	private Collection<Rendezvous> rdv;

	// Constructeur
	public Medecin() {}
	public Medecin(String firstName, String name, Date bitrhDate,
			String numTel,String adresse, String mail, String specialite) {
		super(firstName, name, bitrhDate, numTel, adresse, mail);
		this.specialite = specialite;
	}
	
	// Getters & Setters
	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	@JsonIgnore
	public Collection<Rendezvous> getRendezvous() {
		return rdv;
	}
	
}
