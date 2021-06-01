package com.erp.project.controller;

import java.util.Date;
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

import com.erp.project.DAO.CoulisRepository;
import com.erp.project.DAO.LivraisonRepository;
import com.erp.project.entity.Coulis;
import com.erp.project.entity.Livraison;
import com.erp.project.entity.LivraisonRequest;

@RestController
@CrossOrigin()
@RequestMapping("/livraison")
public class LivraisonController {
	
	@Autowired
	LivraisonRepository livraisonRepository ;
	
	@Autowired
	CoulisRepository coulisRepository ;
// Add Livraison ///
@PostMapping("/addlivraison")
public Livraison addLivraison(@RequestBody Livraison livraison , @PathVariable String refC ) {
	
	Coulis cls = coulisRepository.findByRefCoulis(refC) ; 
	List<Coulis> l = null ;
	l.add(cls);
	

	
	
           
	return  livraisonRepository.save(livraison);
	 
	
}

// Get Livraison by ID
@GetMapping("/getliv/{idLiv}")
public Livraison getOneLivraison(@PathVariable int idLiv) {
	
	return livraisonRepository.findById(idLiv);
	
	
}

//// Get livraison by Adress

////Delete Livraison

@DeleteMapping("/deletliv/{idliv}")
public void deleteLivraison(@PathVariable int idliv) {
	
	
	Livraison livr = livraisonRepository.findById(idliv);
	
	livraisonRepository.delete(livr);
}

//// MaJ Livraison ///


@PutMapping("/updatelivraison/{idliv}")
public Livraison updateLivraison(@RequestBody Livraison livraison,@PathVariable int idliv) {
	
	Livraison livr1 = livraisonRepository.findById(idliv);

	livraisonRepository.save(livr1);
	
	return livr1 ;
	
	
}

}
