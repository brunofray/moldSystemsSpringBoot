package com.projectMoldSystems.immobile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectMoldSystems.immobile.entity.OwnerEntity;
import com.projectMoldSystems.immobile.model.OwnerModel;
import com.projectMoldSystems.immobile.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;
 
	/**CONSULA OS PROPRIETÁRIOS CADASTRADOS*/
	@Transactional(readOnly = true)
	public List<OwnerModel> consultType(){
 
		List<OwnerModel> ownerModel =  new ArrayList<OwnerModel>();
		
		List<OwnerEntity> ownerEntity = this.ownerRepository.findAll();
 
	    ownerEntity.forEach(owner ->{ 
		   ownerModel.add(new OwnerModel(owner.getId(), owner.getName(), owner.getCpf())); 
	    });
 
		return ownerModel;
	}
}
