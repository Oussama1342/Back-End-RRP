package com.erp.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.project.entity.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {

public Reception findByIdReception(int id);
}
