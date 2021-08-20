package com.example.pharma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pharmacie")
public class Pharmacie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ICE;
	
	@Column(name = "Libelle")
	private String Libelle;
	
	@Column(name = "Telephone")
	private int Telephone;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "Adresse")
	private String Adresse;
	
	@Column(name = "Ville")
	private String Ville;
	
	public Pharmacie () {
		
	}
	
	public Pharmacie(String libelle, int telephone, String email, String adresse, String ville) {
		super();
		Libelle = libelle;
		Telephone = telephone;
		Email = email;
		Adresse = adresse;
		Ville = ville;
	}
	public long getICE() {
		return ICE;
	}
	public void setICE(long iCE) {
		ICE = iCE;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public int getTelephone() {
		return Telephone;
	}
	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	
	
}
