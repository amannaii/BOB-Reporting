package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@Table(name = "bob_syga_offre_specifique")
public class SygaOffer {
	@Id
	protected long id_offre; 
	protected String acteur;  
	protected String heure_debut;
	protected String heure_fin;
	protected long prix;
	protected String reference_offre;
	protected int retry;
	public long getId_offre() {
		return id_offre;
	}
	public void setId_offre(long id_offre) {
		this.id_offre = id_offre;
	}
	public String getActeur() {
		return acteur;
	}
	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
	public String getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(String heure_debut) {
		this.heure_debut = heure_debut;
	}
	public String getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public String getReference_offre() {
		return reference_offre;
	}
	public void setReference_offre(String reference_offre) {
		this.reference_offre = reference_offre;
	}
	public int getRetry() {
		return retry;
	}
	public void setRetry(int retry) {
		this.retry = retry;
	}
}
