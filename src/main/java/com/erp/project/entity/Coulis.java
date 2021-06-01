package com.erp.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Coulis {
	
	@Id
	@GeneratedValue
	private int idCoulis ; 
	
    private String refCoulis ;
	private String nonEmeteur ;
	private String addressEmeteur ; 
	private double numtelEmeteur ; 
	
	private String nonRecepteur ;
	private String addressRecepteur ; 
	private double numtelRecepteur ; 
	
	
	private String bureau ;
	private String remboursemant ;
	
    private double montantRemboursement ;
	private double montant ;
	private String modePayement ;
	
	//@ManyToOne
	//private Livraison livraison ; 

	public int getIdCoulis() {
		return idCoulis;
	}

	public void setIdCoulis(int idCoulis) {
		this.idCoulis = idCoulis;
	}

	public String getNonEmeteur() {
		return nonEmeteur;
	}

	public void setNonEmeteur(String nonEmeteur) {
		this.nonEmeteur = nonEmeteur;
	}

	public String getAddressEmeteur() {
		return addressEmeteur;
	}

	public void setAddressEmeteur(String addressEmeteur) {
		this.addressEmeteur = addressEmeteur;
	}

	public double getNumtelEmeteur() {
		return numtelEmeteur;
	}

	public void setNumtelEmeteur(double numtelEmeteur) {
		this.numtelEmeteur = numtelEmeteur;
	}

	public String getNonRecepteur() {
		return nonRecepteur;
	}

	public void setNonRecepteur(String nonRecepteur) {
		this.nonRecepteur = nonRecepteur;
	}

	public String getAddressRecepteur() {
		return addressRecepteur;
	}

	public void setAddressRecepteur(String addressRecepteur) {
		this.addressRecepteur = addressRecepteur;
	}

	public double getNumtelRecepteur() {
		return numtelRecepteur;
	}

	public void setNumtelRecepteur(double numtelRecepteur) {
		this.numtelRecepteur = numtelRecepteur;
	}

	



	public String getRemboursemant() {
		return remboursemant;
	}

	public void setRemboursemant(String remboursemant) {
		this.remboursemant = remboursemant;
	}

	public String getModePayement() {
		return modePayement;
	}

	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}

	public String getRefCoulis() {
		return refCoulis;
	}

	public void setRefCoulis(String refCoulis) {
		this.refCoulis = refCoulis;
	}


	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getMontantRemboursement() {
		return montantRemboursement;
	}

	public void setMontantRemboursement(double montantRemboursement) {
		this.montantRemboursement = montantRemboursement;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
	
  
	
	

}
