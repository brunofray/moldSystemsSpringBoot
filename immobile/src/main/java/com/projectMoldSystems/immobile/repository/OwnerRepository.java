package com.projectMoldSystems.immobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectMoldSystems.immobile.entity.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long>{

}
