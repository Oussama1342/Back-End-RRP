package com.erp.project.controller;

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

import com.erp.project.DAO.LivraisonRepository;
import com.erp.project.DAO.ReceptionRepository;
import com.erp.project.entity.Livraison;
import com.erp.project.entity.Reception;

@RestController
@CrossOrigin()
@RequestMapping("/reception")
public class ReceptionController {

@Autowired
ReceptionRepository receptionRepository ;

@Autowired
LivraisonRepository livraisonRepo ;


/****************************** Add Reception ******************/
@PostMapping("/addReaception")
public Reception addReception(@RequestBody Reception reception) {
	
	receptionRepository.save(reception);
	return reception ;
	
}

/*******************************Edit Reception *****************/
@PutMapping("/edit/{idReception}")
public Reception editReception(@RequestBody Reception reception, @PathVariable int idReception) {
	
	Reception reception2 = receptionRepository.findByIdReception(idReception);
	
	reception2.setNonEmeteur(reception.getNonEmeteur());
	reception2.setAddressEmeteur(reception.getAddressEmeteur());
	reception2.setNumtelEmeteur(reception.getNumtelEmeteur());
	reception2.setNonRecepteur(reception2.getNonRecepteur());
	reception2.setAddressRecepteur(reception.getAddressRecepteur());
	reception2.setNumtelRecepteur(reception.getNumtelRecepteur());
	reception2.setNumReçu(reception.getNumReçu());
	reception2.setRemboursemant(reception.isRemboursemant());
	
	reception2.setDateLivraison(reception.getDateLivraison());
	reception2.setNonChauffeur(reception.getNonChauffeur());
	
	reception2.setMatrCamion(reception.getMatrCamion());
	
	receptionRepository.save(reception2);
	
	return reception2 ;
}
/*********************************Remove Reception ******************/
@DeleteMapping("/remove/{idRecep}")
public void deleteReception(@PathVariable int idRecep) {
	
	Reception reception2 = receptionRepository.findByIdReception(idRecep);
	
	receptionRepository.delete(reception2) ;
}

/****************************** Get Reception par Id ************************/
@GetMapping("/getreception/{idR}")
public Reception OneReception(int idR) {
	
	return receptionRepository.findByIdReception(idR);
}
/****************************** Get All Reception************************/
@GetMapping("/alllreception")
public List<Reception> allReception(){
	
	return receptionRepository.findAll() ;
}


}
