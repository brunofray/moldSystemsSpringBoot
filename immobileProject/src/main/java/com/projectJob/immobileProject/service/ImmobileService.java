package com.projectJob.immobileProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectJob.immobileProject.DAO.ImmobileDAO;
import com.projectJob.immobileProject.entity.ImmobileEntity;
import com.projectJob.immobileProject.model.SearchForm;
import com.projectJob.immobileProject.repository.ImmobileRepository;
import com.projectJob.immobileProject.repository.OwnerRepository;

@Service
@Transactional
public class ImmobileService {

	// INJETA UMA INSTANCIA DA CLASSE DECLARADA COMO ATRIBUTO
		@Autowired
		private ImmobileRepository immobileRepository;
		
		@Autowired
		private ImmobileDAO immobileDAO;
		
		@Autowired
		private OwnerRepository ownerRepository;
		
		//Salva ou atualiza um imovel
		public Boolean save(ImmobileEntity immobileEntity) {

			Boolean bool = immobileRepository.valid(immobileEntity);
			if(bool == false) {
				this.immobileRepository.save(immobileEntity);
			} 
			return bool;
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
		
		// JA NÃO ESTOU UTILIZANDO, O MÉTODO SAVE FUNCIONA PARA AMBOS
		public Boolean alter(ImmobileEntity immobileEntity) {
			Boolean bool = immobileRepository.valid(immobileEntity);
			if(bool == false) {
				this.immobileRepository.saveAndFlush(immobileEntity);
			}
			return bool;
		}
		
		public List<ImmobileEntity> search(SearchForm searchForm){
			return immobileRepository.search(searchForm);
		}
		
//		public List<ImmobileEntity> searchById(Long idImmobile) {
//			return immobileRepository.findByIds(idImmobile);
//		}
		
//		public List<ImmobileEntity> searchByOwner(String owner) {
//			return immobileRepository.findByOwner(owner);
//		}

//		public List<ImmobileEntity> searchByAdress(String street){
//			return immobileRepository.findByStreet(street);
//		}
		
//		public List<ImmobileEntity> search2(Long id, String street, String owner){
//			return immobileRepository.search2(id,street,owner);
//		}
		
}
