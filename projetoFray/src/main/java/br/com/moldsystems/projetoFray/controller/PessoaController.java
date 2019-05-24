package br.com.moldsystems.projetoFray.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.moldsystems.projetoFray.model.PessoaModel;
import br.com.moldsystems.projetoFray.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

		@GetMapping("/")
		public ModelAndView findAll() {
			ModelAndView mv = new ModelAndView("/pessoa");
			mv.addObject("pessoas", pessoaService.listaPessoas());
			
			return mv;
		}
		
		@GetMapping("/add")
		public ModelAndView add(PessoaModel pessoaModel) {
			ModelAndView mv = new ModelAndView("/pessoasAdd");
			mv.addObject("pessoaModel", pessoaModel);
			
			return mv;
		}
		
		@GetMapping("/edit/{id}")
		public ModelAndView edit(@PathVariable("id") Long id) {
			return add(pessoaService.recebePessoa(id));
		}
		
		@GetMapping("/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			pessoaService.deletarPessoa(id);
			
			return findAll();
		}
		
		@PostMapping("/save")
		public ModelAndView save(@Valid PessoaModel pessoaModel, BindingResult result) {
			if(result.hasErrors()) {
				return add(pessoaModel);
			}
			pessoaService.salvarPessoa(pessoaModel);
			
			return findAll();
		}
	
	
//	@GetMapping("/")
//	public ModelAndView findAll(Model model) {
//		ModelAndView mv = new ModelAndView("/pessoas");
//		model.addAttribute("pessoas", this.pessoaService.consultarPessoas());
//		
//		return mv;
//	}
//	
//	@GetMapping("/add")
//	public ModelAndView add(PessoaModel pessoaModel) {
//		ModelAndView mv = new ModelAndView("/pessoaAdd");
//		pessoaService.salvarPessoa(pessoaModel);
//		
//		return mv;
//	}
	
	
}
