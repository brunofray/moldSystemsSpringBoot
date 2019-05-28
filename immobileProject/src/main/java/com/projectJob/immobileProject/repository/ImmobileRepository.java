package com.projectJob.immobileProject.repository;

import java.util.List;

import com.projectJob.immobileProject.entity.ImmobileEntity;
import com.projectJob.immobileProject.entity.OwnerEntity;
import com.projectJob.immobileProject.model.SearchForm;


public interface ImmobileRepository {
	
	
	
	//@Query("select p from immobile p where p.owners.name like %?1%")
//	List<ImmobileEntity> findByOwner(String owners);
	
	//@Query("select p from immobile p where p.street like %?1%")
//	List<ImmobileEntity> findByStreet(String street);
	
	//@Query("select p from immobile p where p.id = ?1")
//	List<ImmobileEntity> findByIds(Long id);

	void save(ImmobileEntity immobileEntity);
	
	ImmobileEntity getOne(Long idImmobile);
	
	void deleteById(Long idImmobile);
	
	List<ImmobileEntity> findAll();
	
	ImmobileEntity saveAndFlush(ImmobileEntity immobileEntity);
	
	List<ImmobileEntity> search(SearchForm searchForm);
	
//	List<ImmobileEntity> search2(Long id, String street, String owners);
	
	Boolean valid(ImmobileEntity immobileEntity);

}
