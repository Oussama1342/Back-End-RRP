package com.erp.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.project.entity.Caisse;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Integer>{

}
