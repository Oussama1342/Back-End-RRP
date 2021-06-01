package com.erp.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.project.DAO.ReceptionRepository;
import com.erp.project.DAO.ReclamationRepository;
import com.erp.project.entity.Reclamation;

@RestController
public class ReclamationController {

@Autowired
ReclamationRepository reclamationRepository  ;

/***********************Add Reclamation *********************** */
@PostMapping("/addReclametion")
public Reclamation addReclamation(Reclamation reclamation) {
	
reclamationRepository.save(reclamation) ;
return reclamation ;
}
/***********************Edit Reclamation *********************** */
@PutMapping("/editReclam/{idReclam}")
public Reclamation editReclamation(@RequestBody Reclamation reclamation, @PathVariable int idReclam) {
	
 Reclamation reclamation2 = reclamationRepository.findByidReclamation(idReclam) ;
 reclamation2.setDescription(reclamation.getDescription());
 
 reclamationRepository.save(reclamation2);
 return reclamation2 ;
}
/***********************Delete Reclamation *********************** */
@DeleteMapping("/removereclam/{idReclam}")
public void deleteReclamation(@PathVariable int idReclam) {
	
	reclamationRepository.delete(reclamationRepository.findByidReclamation(idReclam));
}

/***********************Get all Reclamation *********************** */
@GetMapping("/allreclamation")
public List<Reclamation > allReclamation(){
	return reclamationRepository.findAll() ;
}

@GetMapping("/getReclam/{idReclam}")
public Reclamation OneReclamation(@PathVariable int idReclam) {
	return reclamationRepository.findByidReclamation(idReclam);
}


}
