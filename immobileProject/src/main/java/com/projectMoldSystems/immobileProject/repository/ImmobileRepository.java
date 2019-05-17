package com.projectMoldSystems.immobileProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectMoldSystems.immobileProject.entity.ImmobileEntity;
import com.projectMoldSystems.immobileProject.entity.OwnerEntity;

@Repository
@Transactional
public interface ImmobileRepository extends JpaRepository<ImmobileEntity, Long>{

	@Query("select p from immobile p where p.owners.name like %?1%")
	List<ImmobileEntity> findByOwner(String owners);
	
	@Query("select p from immobile p where p.street like %?1%")
	List<ImmobileEntity> findByAdress(String street);
	
	@Query("select p from immobile p where p.id = ?1")
	List<ImmobileEntity> findByIds(Long id);
	

}
