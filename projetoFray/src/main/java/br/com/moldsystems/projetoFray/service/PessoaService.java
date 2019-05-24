package br.com.moldsystems.projetoFray.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.moldsystems.projetoFray.entity.PessoaEntity;
import br.com.moldsystems.projetoFray.model.PessoaModel;
import br.com.moldsystems.projetoFray.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaModel salvarPessoa(PessoaModel pessoaModel) {
		return pessoaRepository.saveAndFlush(pessoaModel);
	}
	
	public PessoaModel recebePessoa(Long id) {
		return pessoaRepository.getOne(id);
	}
	
//	public PessoaModel editarPessoa(PessoaModel pessoaModel) {
//		return pessoaRepository.saveAndFlush(pessoaModel);
//	}
//	
	public void deletarPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public List<PessoaModel> listaPessoas(){
		return pessoaRepository.findAll();
	}
	
//	public void salvarPessoa(PessoaModel pessoaModel) {
//		PessoaEntity pessoaEntity = new PessoaEntity();
//		
//		pessoaEntity.setNome(pessoaModel.getNome());
//		pessoaEntity.setEmail(pessoaModel.getEmail());
//		pessoaEntity.setCpf(pessoaModel.getCpf());
//		pessoaEntity.setIdade(pessoaModel.getIdade());
//		
//		this.pessoaRepository.save(pessoaEntity);
//	}
//	
//	public List<PessoaModel> consultarPessoas(){
//		
//		List<PessoaModel> pessoaModel = new ArrayList<PessoaModel>();
//		
//		List<PessoaEntity> pessoasEntity = this.pessoaRepository.findAll();
//		
//		pessoasEntity.forEach(pessoaEntity->{
//			
//			pessoaModel.add(
//					new PessoaModel(pessoaEntity.getId(),
//							pessoaEntity.getNome(),
//							pessoaEntity.getEmail(),
//							pessoaEntity.getCpf(),
//							pessoaEntity.getIdade()
//					));
//		});
//		
//		return pessoaModel;
//	}
//	
//	public void excluir(Long idPessoa) {
//		this.pessoaRepository.deleteById(idPessoa);
//	}
//	
//	public void alterarPessoa(PessoaModel pessoaModel) {
//		
//		PessoaEntity pessoaEntity = this.pessoaRepository.getOne(pessoaModel.getId());
//		
//		pessoaEntity.setNome(pessoaModel.getNome());
//		pessoaEntity.setEmail(pessoaModel.getEmail());
//		pessoaEntity.setCpf(pessoaModel.getCpf());
//		pessoaEntity.setIdade(pessoaModel.getIdade());
//		
//		this.pessoaRepository.saveAndFlush(pessoaEntity);
//		
//	}
}
