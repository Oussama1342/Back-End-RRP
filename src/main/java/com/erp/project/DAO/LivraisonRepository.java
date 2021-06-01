package com.erp.project.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.project.entity.Livraison;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Integer> {
	
	public Livraison findById(int idLiv);
	//public List<Livraison> findByAddressRecepteur(String adress);

}
