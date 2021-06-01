package com.erp.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.project.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
