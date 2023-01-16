package com.testspringboot.gestionhospital.models;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="personne")
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements Serializable{
	// !! mettre en absatract class !!
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Pattern(regexp = "^\\w{1,30}$",
			message = "le nom doit seulement contenir des lettres sans "
					+ "caractères spéciaux et doit être obligatoirement renseigné")
	@Column(name="nom")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = "^\\w{1,30}$",
			message = "le prénom doit seulement contenir des lettres sans "
					+ "caractères spéciaux et doit être obligatoirement renseigné")
	@Column(name="prenom")
	private String name;
	
	@NotNull
	@Past
	@Column(name="date_de_naissance")
	private Date bitrhDate;
	
	@Pattern(regexp = "^[0][6|7][0-9]{8}$",
			message = "Numéro non valide doit correspondre à: 06 ou 07 +XXXXXXXX")
	@Column(name="telephone")
	private String numTel;
	
	@Email
	@Column(name="adresse_mail")
	private String mail;
	
	@Length(max = 80)
	@Column(name="adresse")
	private String adresse;
	//private Ville ville;


	// Constructeur
	public Personne() {} // !! IMPORATNT !! provoque une erreur 500
	public Personne(String firstName, String name, Date bitrhDate, String numTel, String adresse, String mail) {
		this.firstName = firstName;
		this.name = name;
		this.bitrhDate = bitrhDate;
		this.numTel = numTel;
		this.adresse = adresse;
		this.mail = mail;
	}
	
	// Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBitrhDate() {
		return bitrhDate;
	}
	public void setBitrhDate(Date bitrhDate) {
		this.bitrhDate = bitrhDate;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
		
}
