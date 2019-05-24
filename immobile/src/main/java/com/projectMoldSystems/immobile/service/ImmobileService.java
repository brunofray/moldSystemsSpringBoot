package com.projectMoldSystems.immobile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectMoldSystems.immobile.entity.ImmobileEntity;
import com.projectMoldSystems.immobile.entity.OwnerEntity;
import com.projectMoldSystems.immobile.entity.TypeImmobileEntity;
import com.projectMoldSystems.immobile.model.ImmobileModel;
import com.projectMoldSystems.immobile.repository.ImmobileRepository;
import com.projectMoldSystems.immobile.repository.OwnerRepository;
import com.projectMoldSystems.immobile.repository.TypeImmobileRepository;

@Service
public class ImmobileService {

	// INJETA UMA INSTANCIA DA CLASSE DECLARADA COMO ATRIBUTO
		@Autowired
		private ImmobileRepository immobileRepository;
		
		@Autowired
		private TypeImmobileRepository typeRepository;
		
		@Autowired
		private OwnerRepository ownerRepository;
		
		//Salva ou atualiza um imovel
		public void save(ImmobileModel immobileModel) {
			
			ImmobileEntity immobileEntity = new ImmobileEntity();
			
			immobileEntity.setCep(immobileModel.getCep());
			immobileEntity.setCity(immobileModel.getCity());
			immobileEntity.setComplement(immobileModel.getComplement());
			immobileEntity.setNeighborhood(immobileModel.getNeighborhood());
			immobileEntity.setNumber(immobileModel.getNumber());
//			immobileEntity.setOwner(immobileModel.getOwner());
			immobileEntity.setPrice(immobileModel.getPrice());
			immobileEntity.setState(immobileModel.getState());
			immobileEntity.setStreet(immobileModel.getStreet());
			
			/*PEGANDO A LISTA DE TIPOS SELECIONADOS*/
			TypeImmobileEntity typeEntity = null;
			List<TypeImmobileEntity> type =  new ArrayList<TypeImmobileEntity>();
			for (Long idType : immobileModel.getTypes()){
	 
				if(idType != null){
	 
					/*CONSULTA TIPO POR CÓDIGO*/	
					typeEntity = typeRepository.getOne(idType);
	 
					/*ADICIONA O TIPO NA LISTA*/
					type.add(typeEntity);
				}
			}
			
			immobileEntity.setType(type);
			
			/*PEGANDO A LISTA DE PROPRIETÁRIOS SELECIONADOS*/
			OwnerEntity ownerEntity = null;
			List<OwnerEntity> owner =  new ArrayList<OwnerEntity>();
			for (Long idOwner : immobileModel.getOwners()) {
					
				if(idOwner != null){
	 
					/*CONSULTA TIPO POR CÓDIGO*/	
					ownerEntity = ownerRepository.getOne(idOwner);
	 
					/*ADICIONA O TIPO NA LISTA*/
					owner.add(ownerEntity);
				}
			}
			
			immobileEntity.setOwner(owner);
			
			this.immobileRepository.save(immobileEntity);
		}
		
		public List<ImmobileModel> consultAll(){
			
			List<ImmobileModel> immobileModel = new ArrayList<ImmobileModel>();
			
			List<ImmobileEntity> immobileEntity = this.immobileRepository.findAll();
			
			
			immobileEntity.forEach(immobileEnt ->{
				immobileModel.add(
						new ImmobileModel(immobileEnt.getId(),
								immobileEnt.getCep(),
								immobileEnt.getStreet(),
								immobileEnt.getNumber(),
								immobileEnt.getComplement(),
								immobileEnt.getNeighborhood(),
								immobileEnt.getCity(),
								immobileEnt.getState(),
								null,
								immobileEnt.getPrice(),
								null
								));
			});
			
			return immobileModel;
		}
		
		public void delete(Long idImmobile) {
			this.immobileRepository.deleteById(idImmobile);
		}
		
		public ImmobileModel consultById(Long idImmobile) {
			
			ImmobileEntity immobileEntity = this.immobileRepository.getOne(idImmobile);
			
			List<Long> typeImmobile = new ArrayList<Long>();
			
			immobileEntity.getType().forEach(type ->{
				typeImmobile.add(type.getId());
				
			});
					return new ImmobileModel(
								immobileEntity.getId(),
								immobileEntity.getCep(),
								immobileEntity.getStreet(),
								immobileEntity.getNumber(),
								immobileEntity.getComplement(),
								immobileEntity.getNeighborhood(),
								immobileEntity.getCity(),
								immobileEntity.getState(),
								typeImmobile,
								immobileEntity.getPrice(),
								null);
		}
		
		public void alter(ImmobileModel immobileModel) {
			
			ImmobileEntity immobileEntity = this.immobileRepository.getOne(immobileModel.getId());
			
			immobileEntity.setCep(immobileModel.getCep());
			immobileEntity.setCity(immobileModel.getCity());
			immobileEntity.setComplement(immobileModel.getComplement());
			immobileEntity.setNeighborhood(immobileModel.getNeighborhood());
			immobileEntity.setNumber(immobileModel.getNumber());
//			immobileEntity.setOwner(immobileModel.getOwner());
			immobileEntity.setPrice(immobileModel.getPrice());
			immobileEntity.setState(immobileModel.getState());
			immobileEntity.setStreet(immobileModel.getStreet());
			
			/*PEGANDO A LISTA DE TIPOS SELECIONADOS*/
			TypeImmobileEntity typeEntity = null;
			List<TypeImmobileEntity> type =  new ArrayList<TypeImmobileEntity>();
			for (Long idType : immobileModel.getTypes()){
	 
	 
				if(idType != null){
	 
					/*CONSULTA TIPO POR CÓDIGO*/	
					typeEntity = typeRepository.getOne(idType);
	 
					/*ADICIONA O TIPO NA LISTA*/
					type.add(typeEntity);
				}
			}
			immobileEntity.setType(type);
			
			/*PEGANDO A LISTA DE PROPRIETÁRIOS SELECIONADOS*/
			OwnerEntity ownerEntity = null;
			List<OwnerEntity> owner =  new ArrayList<OwnerEntity>();
			for (Long idOwner : immobileModel.getOwners()) {
					
				if(idOwner != null){
	 
					/*CONSULTA TIPO POR CÓDIGO*/	
					ownerEntity = ownerRepository.getOne(idOwner);
	 
					/*ADICIONA O TIPO NA LISTA*/
					owner.add(ownerEntity);
				}
			}
			
			immobileEntity.setOwner(owner);
			
			this.immobileRepository.saveAndFlush(immobileEntity);
			
		}
}
