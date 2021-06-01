package com.erp.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Facture {

	@Id
	@GeneratedValue
	private int idFact ;
	private  String refFacture ; 
	private Date dateFacture ; 
    private String client ; 
	private double priceTTC ; 
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Livraison", referencedColumnName = "idlivraison")
	private Livraison livraison ;

public Facture() {
	// TODO Auto-generated constructor stub
}

public int getIdFact() {
	return idFact;
}

public void setIdFact(int idFact) {
	this.idFact = idFact;
}

public Date getDateFacture() {
	return dateFacture;
}

public void setDateFacture(Date dateFacture) {
	this.dateFacture = dateFacture;
}

public double getPriceTTC() {
	return priceTTC;
}

public void setPriceTTC(double priceTTC) {
	this.priceTTC = priceTTC;
}

public Livraison getLivraison() {
	return livraison;
}

public void setLivraison(Livraison livraison) {
	this.livraison = livraison;
}

public String getClient() {
	return client;
}

public void setClient(String client) {
	this.client = client;
}

public String getRefFacture() {
	return refFacture;
}

public void setRefFacture(String refFacture) {
	this.refFacture = refFacture;
}


}
