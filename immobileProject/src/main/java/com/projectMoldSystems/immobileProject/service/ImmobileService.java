package com.projectMoldSystems.immobileProject.service;

import java.util.List;

import org.apache.catalina.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectMoldSystems.immobileProject.entity.ImmobileEntity;
import com.projectMoldSystems.immobileProject.entity.OwnerEntity;
import com.projectMoldSystems.immobileProject.repository.ImmobileRepository;
import com.projectMoldSystems.immobileProject.repository.OwnerRepository;

@Service
public class ImmobileService {

	// INJETA UMA INSTANCIA DA CLASSE DECLARADA COMO ATRIBUTO
		@Autowired
		private ImmobileRepository immobileRepository;
		
		@Autowired
		private OwnerRepository ownerRepository;
		
		//Salva ou atualiza um imovel
		public ImmobileEntity save(ImmobileEntity immobileEntity) {

			
			return immobileRepository.save(immobileEntity);
		}
		
		public List<ImmobileEntity> consultAll(){
			
			return immobileRepository.findAll();	
		
		}
		
		public void delete(Long idImmobile) {
			this.immobileRepository.deleteById(idImmobile);
		}
		
		public ImmobileEntity consultById(Long idImmobile) {
			
			return immobileRepository.getOne(idImmobile);

		}
		
		public List<ImmobileEntity> searchById(Long idImmobile) {
			return immobileRepository.findByIds(idImmobile);
		}
		
		public List<ImmobileEntity> searchByOwner(String owner) {
			return immobileRepository.findByOwner(owner);
		}
		
		public List<ImmobileEntity> searchByAdress(String street){
			return immobileRepository.findByAdress(street);
		}
		
		public ImmobileEntity alter(ImmobileEntity immobileEntity) {
			
			return immobileRepository.saveAndFlush(immobileEntity);
			
		}
		
//		public ImmobileEntity findByOwner(OwnerEntity owner) {
//			return immobileRepository.findByOwner(owner);
//		}
//		
//		public ImmobileEntity findByAdress(String street) {
//			return immobileRepository.findByAdress(street);
//		}
}
