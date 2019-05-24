package br.com.fraybruno.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fraybruno.webapp.entity.UsuarioEntity;
 
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
 
	UsuarioEntity findByLogin(String login);
 
}