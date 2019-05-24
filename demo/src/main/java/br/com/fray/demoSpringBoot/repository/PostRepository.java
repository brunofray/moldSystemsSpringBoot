package br.com.fray.demoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fray.demoSpringBoot.model.Post;

@Repository //Define a classe como um bean do Spring
public interface PostRepository extends JpaRepository<Post, Long>{

	// FINALIDADE DE FACILITAR OPERAÇÕES ENTRE TABELAS DE BANCOS DE DADOS E OBJETOS JAVA
	
	//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)
}
