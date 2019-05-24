package br.com.fray.demoSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fray.demoSpringBoot.model.Post;
import br.com.fray.demoSpringBoot.repository.PostRepository;

@Service //Define a classe como um bean do Spring
public class PostService {
	
	// INJETA UMA INSTANCIA DA CLASSE DECLARADA COMO ATRIBUTO
	@Autowired
	private PostRepository repository;
	
	//Retorna uma lista com todos posts inseridos
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	//Retorno um post a partir do ID
	public Post findOne(Long id) {
		return repository.getOne(id);
	}
	
	//Salva ou atualiza um post
	public Post save(Post post) {
		return repository.saveAndFlush(post);
	}
	
	//Exclui um post
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
