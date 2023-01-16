package com.testspringboot.gestionhospital.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;

@Entity
@Table(name = "rendezvous")
public class Rendezvous implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@DateTimeFormat
	@Future
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "fk_consulatation")
	private Consultation cons;
	
	@ManyToOne
	@JoinColumn(name = "fk_medecin")
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name = "fk_patient")
	private Patient patient;

	// Constructeur
	public Rendezvous() {}
	public Rendezvous(Date date, Consultation consultation, Medecin medecin, Patient patient) {
		this.date = date;
		this.cons = consultation;
		this.medecin = medecin;
		this.patient = patient;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Consultation getCons() {
		return cons;
	}
	public void setCons(Consultation consultation) {
		this.cons = consultation;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
