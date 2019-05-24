package com.projectMoldSystems.immobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectMoldSystems.immobile.entity.ImmobileEntity;
import com.projectMoldSystems.immobile.model.ImmobileModel;

@Repository
public interface ImmobileRepository extends JpaRepository<ImmobileEntity, Long>{

}
