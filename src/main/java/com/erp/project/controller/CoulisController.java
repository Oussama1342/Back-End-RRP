package com.erp.project.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.project.DAO.CaisseRepository;
import com.erp.project.DAO.CoulisRepository;
import com.erp.project.DAO.FactureRepository;
import com.erp.project.entity.Caisse;
import com.erp.project.entity.Coulis;
import com.erp.project.entity.Facture;
import com.erp.project.entity.Reception;

@RestController
@CrossOrigin()
@RequestMapping("/coulis")
public class CoulisController {

@Autowired
CoulisRepository coulisRepository ;

@Autowired
FactureRepository factureRepo ;

@Autowired
CaisseRepository caisseRepo ;

@PostMapping("/addcoulis")
public Coulis addCoulis(@RequestBody Coulis coulis ) {
	Facture facture = new Facture ();
	Caisse caisse = new Caisse ();
    

	if(coulis.getModePayement().equalsIgnoreCase("Facture")) {
		facture.setRefFacture(coulis.getRefCoulis());

		facture.setClient(coulis.getNonEmeteur());
		facture.setPriceTTC(coulis.getMontant()) ; 
		factureRepo.save(facture);
	}
	else if(coulis.getModePayement().equalsIgnoreCase("Caisse")) {
		caisse.setRefCaisse(coulis.getRefCoulis());
		caisse.setClient(coulis.getNonEmeteur());
		caisse.setMontant(coulis.getMontant());
		caisseRepo.save(caisse);
	}
	
    
	return coulisRepository.save(coulis);
}

@GetMapping("/allcolis")
public List<Coulis> allcolis(){
	
	return coulisRepository.findAll();
	
}








///***** Search Coulis ****/




}
