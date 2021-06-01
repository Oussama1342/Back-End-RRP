package com.erp.project.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erp.project.DAO.CompteRepository;
import com.erp.project.entity.Compte;

@RestController
@CrossOrigin()
@RequestMapping("/compte")
public class CompteController {
	
	@Autowired
	CompteRepository compteRepository ;
	
	// add Compte ////
	@PostMapping("/signup")
	public Compte addCompte(@RequestBody Compte cmpt) {
		
		return compteRepository.save(cmpt);
	}
	

	
	
	///Recupere tous les comptes existants ///
	@GetMapping("/allcompte")
	public Collection<Compte> allCompte(){
		
		return compteRepository.findAll();
	}
	
	
	///Recupere un seul compte par id ///
	
	@GetMapping("/getCompt/{idCmpt}")
	public Compte OneUser(@PathVariable int idCmpt) {
		
		return compteRepository.findById(idCmpt) ;
	}
	
	
	////recupere tous les comptes de meme bureau //
	
	
	@GetMapping("/listcmpt/{bureau}")
	public Collection<Compte>  listescompte(@PathVariable String bureau)
	{
		return compteRepository.findByBureau(bureau);
	}
	
	/// Mise a jour Compte ///
	
	@PutMapping("/modif/{idCmpt}")
	public Compte updateCompte(@RequestBody Compte cmpt,@PathVariable int idCmpt) {
		
	try {
		Compte	cmpt1 = compteRepository.findById(idCmpt);
	cmpt1.setLogin(cmpt.getLogin());
	cmpt1.setPassword(cmpt.getPassword());
	cmpt1.setBureau(cmpt.getBureau());
	
	compteRepository.save(cmpt1);
	return cmpt1 ;
	}catch (Exception e) {
		e.printStackTrace() ;
		return cmpt ;
		
	}
	
	}
	
	@DeleteMapping("/deletecmpt/{idCmpt}")
	public void deleteCompte(@PathVariable int idCmpt) {
		
		Compte cmp1 = compteRepository.findById(idCmpt);
		compteRepository.delete(cmp1);
	}
}
