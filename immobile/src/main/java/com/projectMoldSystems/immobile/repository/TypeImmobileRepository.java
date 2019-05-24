package com.projectMoldSystems.immobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectMoldSystems.immobile.entity.TypeImmobileEntity;
import com.projectMoldSystems.immobile.model.TypeImmobileModel;

@Repository
public interface TypeImmobileRepository extends JpaRepository<TypeImmobileEntity, Long>{

}
