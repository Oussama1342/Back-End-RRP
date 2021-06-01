package com.erp.project.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.project.entity.Coulis;

public interface CoulisRepository extends JpaRepository<Coulis, Integer> {
	
	public Coulis findByRefCoulis(String refcoulis) ; 
	public Coulis findByIdCoulis(int idcolis);
	public List<Coulis>  findByBureau(String  bureau);

}
