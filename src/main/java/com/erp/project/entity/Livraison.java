package com.erp.project.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Livraison {

	@Id
	@GeneratedValue
	private int idlivraison ; 
	
	private String refLivraison ;
    private String nonChauffeur ;
    private String matCamion ;
    private Date dateLivraison ;
    

  //  @OneToMany(targetEntity = Coulis.class, cascade = CascadeType.ALL)
  //  @JoinColumn(name = "idcoulis", referencedColumnName = "idlivraison" )
  //  private List<Coulis> coulis ;
    
	public int getIdlivraison() {
		return idlivraison;
	}
	public void setIdlivraison(int idlivraison) {
		this.idlivraison = idlivraison;
	}
	public String getRefLivraison() {
		return refLivraison;
	}
	public void setRefLivraison(String refLivraison) {
		this.refLivraison = refLivraison;
	}
	public String getNonChauffeur() {
		return nonChauffeur;
	}
	public void setNonChauffeur(String nonChauffeur) {
		this.nonChauffeur = nonChauffeur;
	}
	public String getMatCamion() {
		return matCamion;
	}
	public void setMatCamion(String matCamion) {
		this.matCamion = matCamion;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	
    
   // @OneToMany(mappedBy = "livraison", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
                                                
   // private List<Coulis> coulis ; 
    
    
    
}
