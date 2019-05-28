package com.projectJob.immobileProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectJob.immobileProject.entity.OwnerEntity;
import com.projectJob.immobileProject.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;
 
	/**CONSULA OS PROPRIETÁRIOS CADASTRADOS*/
	@Transactional(readOnly = true)
	public List<OwnerEntity> consultType(){
 
		
		List<OwnerEntity> ownerEntity = this.ownerRepository.findAll();
 
 
		return ownerEntity;
	}
	
	public OwnerEntity consultById(Long id) {
		OwnerEntity ownerEntity = this.ownerRepository.getOne(id);
		ownerEntity.getName();
		
		return ownerEntity;
		
	}
//	public List<OwnerEntity> consultByName(String name){
//		List<OwnerEntity> ownerEntity = this.ownerRepository.findByName(name);
//		
//		return ownerEntity;
//	}
}
