package com.projectMoldSystems.immobileProject.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.projectMoldSystems.immobileProject.entity.ImmobileEntity;
import com.projectMoldSystems.immobileProject.repository.ImmobileRepository;

public class ImmobileDAO implements ImmobileRepository{

	ImmobileRepository immobileRepository;
	
	@Override
	public List<ImmobileEntity> findByOwner(String owners) {
		List<ImmobileEntity> immobileEntity = immobileRepository.findByOwner(owners);
		
		return null;
	}

	@Override
	public List<ImmobileEntity> findByAdress(String street) {
		List<ImmobileEntity> immobileEntity = immobileRepository.findByAdress(street);
		
		return null;
	}

	@Override
	public List<ImmobileEntity> findByIds(Long id) {

		List<ImmobileEntity> immobileEntity = immobileRepository.findByIds(id);
		
		return null;
	}


	@Override
	public List<ImmobileEntity> findAll() {
		
		return null;
	}


	@Override
	public List<ImmobileEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ImmobileEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends ImmobileEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteInBatch(Iterable<ImmobileEntity> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ImmobileEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<ImmobileEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<ImmobileEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(ImmobileEntity entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends ImmobileEntity> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends ImmobileEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends ImmobileEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends ImmobileEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
