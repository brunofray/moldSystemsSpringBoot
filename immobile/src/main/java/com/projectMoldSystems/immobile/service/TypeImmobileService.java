package com.projectMoldSystems.immobile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectMoldSystems.immobile.entity.TypeImmobileEntity;
import com.projectMoldSystems.immobile.model.TypeImmobileModel;
import com.projectMoldSystems.immobile.repository.TypeImmobileRepository;

@Service
@Transactional
public class TypeImmobileService {

	@Autowired
	private TypeImmobileRepository typeRepository;
 
	/**CONSULA OS TIPOS CADASTRADOS*/
	@Transactional(readOnly = true)
	public List<TypeImmobileModel> consultType(){
 
		List<TypeImmobileModel> typeModel =  new ArrayList<TypeImmobileModel>();
		
		List<TypeImmobileEntity> typeEntity = this.typeRepository.findAll();
 
	    typeEntity.forEach(type ->{ 
		   typeModel.add(new TypeImmobileModel(type.getId(), type.getDescription())); 
	    });
 
		return typeModel;
	}
}
