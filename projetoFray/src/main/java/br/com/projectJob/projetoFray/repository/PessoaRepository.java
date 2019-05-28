package br.com.projectJob.projetoFray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projectJob.projetoFray.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{

}
