package com.erp.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.project.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {

	
public Reclamation findByidReclamation(int id) ;
}
