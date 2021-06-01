package com.erp.project.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.project.entity.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
	
public List<Compte> findByBureau(String bureau);
public Compte findById(int idcmpt);

}
