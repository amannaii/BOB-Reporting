package com.sqli.client.rte.bob.reporting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bob_syga_offre_spec_rejected")
public class SygaOfferRejected //extends SygaOffer
{
	@Id
	protected long id_offre; 
	protected String acteur;  
	protected String heure_debut;
	protected String heure_fin;
	protected long prix;
	protected String reference_offre;
	protected int retry;

}
