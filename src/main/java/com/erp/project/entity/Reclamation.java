package com.erp.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reclamation {

	@Id
	@GeneratedValue
	private int idReclamation ;
	
	private String description ; 
	
	public Reclamation() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
