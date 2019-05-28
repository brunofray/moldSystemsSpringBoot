package com.projectJob.immobileProject.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectJob.immobileProject.entity.ImmobileEntity;
<<<<<<< HEAD
=======
import com.projectJob.immobileProject.entity.OwnerEntity;
import com.projectJob.immobileProject.hibernate.util.HibernateUtil;
>>>>>>> 2cd6e787920a66e6a77b27bfffbd44fb81b353b3
import com.projectJob.immobileProject.model.SearchForm;
import com.projectJob.immobileProject.repository.ImmobileRepository;

@Repository
@Transactional
public class ImmobileDAO implements ImmobileRepository{

	@Autowired
	EntityManagerFactory entityManagerFactory;

//	private EntityManager entityManager = HibernateUtil.geEntityManager();
	
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
	
	@PostConstruct
	public void init() {

		sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	}
	
	@Override
	public void save(ImmobileEntity immobileEntity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
//		String cep = immobileEntity.getCep();
//		String street = immobileEntity.getStreet();
//		Integer number = immobileEntity.getNumber();
//		String neighborhood = immobileEntity.getNeighborhood();
//		String complement = immobileEntity.getComplement();
//		String city = immobileEntity.getCity();
//		String state = immobileEntity.getState(); 
		try {
			transaction.begin();
//			if(immobileEntity.getStreet().equals(immobileEntity)) {
//				String hql = "from immobile p where 1=1";
//				if(! cep.equals("")) {
//					hql += " and p.cep like :cep";
//				}if(! street.equals("")) {
//					hql += " and p.street like :street";
//				}
//				Query query = entityManager.createQuery(hql);
//				if(! cep.equals("")) {
//					query.setParameter("cep", cep + "%");
//				}if(! street.equals("")) {
//					query.setParameter("street", street + "%");
//				}
//			}
			if (immobileEntity.getId() == null) {
				entityManager.persist(immobileEntity);
			} else {
				entityManager.merge(immobileEntity);
			}
			
			transaction.commit();
		} finally {
			entityManager.close();
		}
		
		
//		return (Long) sessionFactory.getCurrentSession().save( immobileEntity );		
	}
	
	@SuppressWarnings("unchecked")
	public List<ImmobileEntity> findAll() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<ImmobileEntity> immobileEntity = null;
		try {
			transaction.begin();
//			List<ImmobileEntity> = entityManager.createQuery("from " + immobileEntity.getId()).getResultList();
			
//			sessionFactory.getCurrentSession();
//			
			String hql = "FROM immobile";
//			
//			String sql = "Select new" + ImmobileEntity.class.getName()
//					+ "(e.id,e.cep,e.street,e.number,e.neighborhood,e.complement,e.city,e.state,e.types,e.price,e.owners"
//					+ "from" + ImmobileEntity.class.getName() + "e";
//			
//			Session session = this.sessionFactory.getCurrentSession();
			Query query = entityManager.createQuery(hql);
//			Query<ImmobileEntity> query2 = session.createQuery(sql, ImmobileEntity.class);
			
			immobileEntity = query.getResultList();
			transaction.commit();
			
		} finally {
			entityManager.close();
		}	
		return immobileEntity;
	}

	@Override
	public ImmobileEntity getOne(Long idImmobile) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ImmobileEntity immobileEntity = null;
		try {
			immobileEntity = entityManager.find(ImmobileEntity.class, idImmobile);
		} finally {
			entityManager.close();
		}
		return immobileEntity;
	}

	@Override
	public void deleteById(Long idImmobile) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			ImmobileEntity immobileEntity = entityManager.find(ImmobileEntity.class, idImmobile);
			entityManager.remove(immobileEntity);
			transaction.commit();
		} finally {
			entityManager.close();
		}
		
	}

	// JA NÃO ESTOU USANDO, O MÉTODO SAVE FUNCIONA PARA AMBOS.
	@Override
	public ImmobileEntity saveAndFlush(ImmobileEntity immobileEntity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			immobileEntity = entityManager.merge(immobileEntity);
			transaction.commit();
		} finally {
			entityManager.close();
		}
		
		return immobileEntity;
	}

	@Override
	public List<ImmobileEntity> search(SearchForm searchForm) {
		
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<ImmobileEntity> immobileEntity = null;
		try {
			transaction.begin();
			String hql = "from immobile p where 1=1";
			if(searchForm.getIdSearch() != null) {
				hql += " and p.id = :id";
			}if(! searchForm.getNameStreet().equals("")) {
				hql += " and p.street like :street";
			}if(! searchForm.getNameSearch().equals("")) {
				hql += " and p.owners.name like :owners";
			}
			Query query = entityManager.createQuery(hql);
			if(searchForm.getIdSearch() != null) {
				query.setParameter("id", searchForm.getIdSearch());
			}if(! searchForm.getNameStreet().equals("")) {
				query.setParameter("street", searchForm.getNameStreet() + "%");
			}if(! searchForm.getNameSearch().equals("")) {
				query.setParameter("owners", searchForm.getNameSearch() + "%");
			}
			immobileEntity = query.getResultList();
			transaction.commit();
		} finally {
			entityManager.close();
		}
		
		return immobileEntity;
	}

	@Override
	public Boolean valid(ImmobileEntity immobileEntity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
//		List<ImmobileEntity> immobileEnt = null;
		List<ImmobileEntity> immobileEntHQL = null;
		Boolean bool = false;
		
		try {
			transaction.begin();
			
			String hql = "select p from immobile p where p.cep = :cep" +
				    " and p.street = :street" +
				    " and p.number = :number" +
				    " and p.neighborhood = :neighborhood" +
				    " and p.complement = :complement" +
				    " and p.city = :city" +
				    " and p.state = :state";
			
			Query query = entityManager.createQuery(hql);
				query.setParameter("cep", immobileEntity.getCep())
				   .setParameter("street", immobileEntity.getStreet())
				   .setParameter("number", immobileEntity.getNumber())
				   .setParameter("neighborhood", immobileEntity.getNeighborhood())
				   .setParameter("complement", immobileEntity.getComplement())
				   .setParameter("city", immobileEntity.getCity())
				   .setParameter("state", immobileEntity.getState());
			immobileEntHQL = query.getResultList();
		
			if (! immobileEntHQL.isEmpty()) {
				bool = true;
			} 
			
			for (ImmobileEntity immobile : immobileEntHQL) {
				if ( immobileEntity.getId().equals(immobile.getId())) {
					bool = false;
				}
			}
			
//			bool = immobileEntity.equals(immobileEntHQL);
//			
//			for (Object immobile : immobileEntHQL) {
//				ImmobileEntity immobileEntit = (ImmobileEntity) immobile;
//				
//			}
			
			// VALIDAÇÃO FUNCIONAL DE ENDEREÇO
//				  String hql = "FROM immobile";
//			      Query query = entityManager.createQuery(hql);
//				  immobileEnt = query.getResultList();
//				  for (ImmobileEntity immobile: immobileEnt) {
//					   if(immobileEntity.getCep().equals(immobile.getCep())) {
//						   if(immobileEntity.getStreet().equals(immobile.getStreet())) {
//							   if(immobileEntity.getNumber().equals(immobile.getNumber())) {
//								   if(immobileEntity.getComplement().equals(immobile.getComplement())) {
//									   if(immobileEntity.getNeighborhood().equals(immobile.getNeighborhood())) {
//										   if(immobileEntity.getCity().equals(immobile.getCity())) {
//											   if(immobileEntity.getState().equals(immobile.getState())) {
//												   bool = true;
//												   break;
//											   }
//										   }
//									   }
//								   }
//							   }
//						   }
//					   }
//				  	}
				
//			ImmobileEntity immobileEn = entityManager.find(ImmobileEntity.class, 1L);
//			String sql = "select p from immobile p where p.street like :street";
//		    Query consult = entityManager.createQuery(sql);
//		    consult.setParameter("street", immobileEntity.getStreet() + "%");
//		    System.out.println("unico = "+ consult.getSingleResult());
		   
//		    if(! immobileEntity.getStreet().equals(immobileEn.getStreet())) {
//		    	System.out.println("Essa rua ja existe!");
//		    	entityManager.persist(immobileEntity);
		    	
//		    }
//		    return (ImmobileEntity) consult.getSingleResult();
		    transaction.commit();
		    return bool;
		} finally {
			entityManager.close();
		}
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ImmobileEntity> findByOwner(String owners) {
//	
//		
////		List<ImmobileEntity> immobileEntity = immobileRepository.findByOwner(owners);
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		List<ImmobileEntity> immobileEntity = null;
//		try {
//			transaction.begin();
//			String hql = "SELECT p FROM immobile p WHERE p.owners.name LIKE :owners";		
//			Query query = entityManager.createQuery(hql).setParameter("owners", owners + "%");
//			
//			immobileEntity = query.getResultList();
//			
//			transaction.commit();
//		} finally {
//			entityManager.close();
//		}
//		
//		
//		return immobileEntity;
//	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ImmobileEntity> findByStreet(String street) {
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		List<ImmobileEntity> immobileEntity = null;
//		try {
//			transaction.begin();
//			String hql = "SELECT p FROM immobile p WHERE p.street LIKE :street";		
//			Query query = entityManager.createQuery(hql).setParameter("street", street + "%");
//			
//			immobileEntity = query.getResultList();
//			
//			transaction.commit();
//		} finally {
//			entityManager.close();
//		}
//		
//		return immobileEntity;
//	}

//	@Override
//	public List<ImmobileEntity> findByIds(Long id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		
//		return null;
//	}
	
	// SUBSTITUIDO PELO SEARCH QUE ESTÁ FUNCIONAL
//	@Override
//	public List<ImmobileEntity> search2(Long id, String street, String owners) {
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		List<ImmobileEntity> immobileEntity = null;
//		try {
//			transaction.begin();
//			String hql = "from immobile p where 1=1";
//			if( id != null) {
//				hql += " and p.id = :id";
//			}if(! street.equals("")) {
//				hql += " and p.street like :street";
//			}if(! owners.equals("")) {
//				hql += " and p.owners.name like :owners";
//			}
//			Query query = entityManager.createQuery(hql);
//			if( id != null) {
//				query.setParameter("id", id);
//			}if(! street.equals("")) {
//				query.setParameter("street", street + "%");
//			}if(! owners.equals("")) {
//				query.setParameter("owners", owners + "%");
//			}
//			immobileEntity = query.getResultList();
//			transaction.commit();
//		} finally {
//			entityManager.close();
//		}
//		
//		return immobileEntity;
//	}
	
}
