package com.projectJob.immobileProject.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectJob.immobileProject.entity.OwnerEntity;
import com.projectJob.immobileProject.repository.OwnerRepository;

@Repository
@Transactional
public class OwnerDAO implements OwnerRepository{

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	private SessionFactory sessionFactory;
	
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	      //Obtém o factory a partir da unidade de persistência.
	      factory = Persistence.createEntityManagerFactory("immobileProject");
	      //Cria um entity manager.
	      entityManager = factory.createEntityManager();
	      //Fecha o factory para liberar os recursos utilizado.
	    
	    return entityManager;
	  }
	
	@SuppressWarnings("unchecked")
	public List<OwnerEntity> findAll() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<OwnerEntity> ownerEntity = null;
		try {
			transaction.begin();
			String hql = "FROM owner";
			Query query = entityManager.createQuery(hql);
			ownerEntity = query.getResultList();
			transaction.commit();
			
		} finally {
			entityManager.close();
		}	
		return ownerEntity;
	}
}
