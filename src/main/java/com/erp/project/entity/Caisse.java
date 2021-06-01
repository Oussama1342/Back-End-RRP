package com.erp.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Caisse {

@Id
@GeneratedValue
private int idCaisse;
private String refCaisse ;
private String client ; 
private double montant ;
public int getIdCaisse() {
	return idCaisse;
}
public void setIdCaisse(int idCaisse) {
	this.idCaisse = idCaisse;
}
public String getRefCaisse() {
	return refCaisse;
}
public void setRefCaisse(String refCaisse) {
	this.refCaisse = refCaisse;
}
public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
} 


}
