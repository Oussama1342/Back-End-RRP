package com.erp.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reception {

	@Id
	@GeneratedValue

	private int idReception ; 
	
	private String nonEmeteur ;
	private String addressEmeteur ; 
	private double numtelEmeteur ; 
	
	private String nonRecepteur ;
	private String addressRecepteur ; 
	private double numtelRecepteur ; 
	
	private double numReçu ;
	
	private boolean remboursemant ;
	
	private Date dateLivraison ;
	
	private String nonChauffeur ;
	
	private String matrCamion ; 
	
	public Reception() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReception() {
		return idReception;
	}

	public void setIdReception(int idReception) {
		this.idReception = idReception;
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

	public double getNumReçu() {
		return numReçu;
	}

	public void setNumReçu(double numReçu) {
		this.numReçu = numReçu;
	}

	public boolean isRemboursemant() {
		return remboursemant;
	}

	public void setRemboursemant(boolean remboursemant) {
		this.remboursemant = remboursemant;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getNonChauffeur() {
		return nonChauffeur;
	}

	public void setNonChauffeur(String nonChauffeur) {
		this.nonChauffeur = nonChauffeur;
	}

	public String getMatrCamion() {
		return matrCamion;
	}

	public void setMatrCamion(String matrCamion) {
		this.matrCamion = matrCamion;
	}
	
	
	
}
