package com.projectMoldSystems.immobileProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectMoldSystems.immobileProject.entity.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long>{

	@Query("select p from owner p where p.name like %?1%")
	List<OwnerEntity> findByName(String name);
}
