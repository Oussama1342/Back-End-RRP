package com.erp.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.project.DAO.FactureRepository;
import com.erp.project.entity.Facture;

@RestController
@CrossOrigin()
@RequestMapping("/facture")
public class FactureController {

	@Autowired
	FactureRepository factureRepository ;
	
	@PostMapping("/addFact")
	public Facture addFacture(@RequestBody Facture facture) {
		facture.setDateFacture(new Date());
		factureRepository.save(facture);
		return facture ;
		
	}
	
	@GetMapping("/allfacture")
	public List<Facture > allFacture(){
		
		return factureRepository.findAll() ;
	}
}
