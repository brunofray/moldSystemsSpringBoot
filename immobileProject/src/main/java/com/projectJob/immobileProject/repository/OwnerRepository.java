package com.projectJob.immobileProject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projectJob.immobileProject.entity.OwnerEntity;

@Repository
public interface OwnerRepository{

//	@Query("select p from owner p where p.name like %?1%")
//	List<OwnerEntity> findByName(String name);
	
	List<OwnerEntity> findAll();
}
