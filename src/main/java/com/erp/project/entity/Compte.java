package com.erp.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compte {
    
	@Id
	@GeneratedValue
	private int id_Compte; 
	
	private String login ; 
	
	private String password ;
	
	private String bureau ; 
	

	
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public int getId_Compte() {
		return id_Compte;
	}

	public void setId_Compte(int id_Compte) {
		this.id_Compte = id_Compte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	
	
	
	
	
}
