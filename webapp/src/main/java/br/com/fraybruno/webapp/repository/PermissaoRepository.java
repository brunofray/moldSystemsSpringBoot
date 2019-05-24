package br.com.fraybruno.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fraybruno.webapp.entity.GrupoEntity;
import br.com.fraybruno.webapp.entity.PermissaoEntity;
 
@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
 
	List<PermissaoEntity> findByGruposIn(GrupoEntity grupoEntity);
}