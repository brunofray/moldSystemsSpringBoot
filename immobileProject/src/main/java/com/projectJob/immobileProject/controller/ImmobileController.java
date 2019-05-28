package com.projectMoldSystems.immobileProject.controller;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectMoldSystems.immobileProject.entity.ImmobileEntity;
import com.projectMoldSystems.immobileProject.entity.OwnerEntity;
import com.projectMoldSystems.immobileProject.model.SearchForm;
import com.projectMoldSystems.immobileProject.repository.ImmobileRepository;
import com.projectMoldSystems.immobileProject.repository.OwnerRepository;
import com.projectMoldSystems.immobileProject.service.ImmobileService;
import com.projectMoldSystems.immobileProject.service.OwnerService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ImmobileController {

	@Autowired
	private ImmobileService immobileService;
	
	@Autowired
	private ImmobileRepository immobileRepository;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value="/newCadaster", method= RequestMethod.GET)
	public ModelAndView newCadaster(Model model) {
		
		model.addAttribute("owners", ownerService.consultType());
		ImmobileEntity immobileEntity = new ImmobileEntity();
		
		List<String> types = new ArrayList<String>();
		types.add("Locação");
		types.add("Venda");
		model.addAttribute("types", types);
		
		model.addAttribute("immobileEntity", immobileEntity);
				
		return new ModelAndView("newCadaster");
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView saveImmobile(@ModelAttribute
									@Valid ImmobileEntity immobileEntity,
									final BindingResult result,
									Model model,
									RedirectAttributes redirectAttributes) {
		Boolean bool = false;
		ModelAndView andView = new ModelAndView("/newCadaster");
		if(result.hasErrors()) {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			andView.addObject("owners", ownerEntity);
			
			andView.addObject("immobileEntity", immobileEntity);
			
			return andView;
		}else {
			
			bool = immobileService.save(immobileEntity);
		}
		
		
		ModelAndView modelAndView = new ModelAndView("redirect:/newCadaster");
		if(bool == false ) {
			redirectAttributes.addFlashAttribute("msg_result_success", "Registro salvo com sucesso!");
		} else {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			andView.addObject("owners", ownerEntity);
			
			andView.addObject("immobileEntity", immobileEntity);
//			redirectAttributes.addFlashAttribute("msg_result_fail", "Colisão de endereço, impossivel salvar!");
			
			andView.addObject("msg_result_fail", "Colisão de endereço, impossivel salvar!");
			
			return andView;
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/consult", method= RequestMethod.GET)
	public ModelAndView consult(Model model) {
		
		
		model.addAttribute("immobileEntity", this.immobileService.consultAll());
		
		
		return new ModelAndView("consult");
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public ModelAndView delete(@RequestParam("idImmobile") Long idImmobile) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/consult");
		
		this.immobileService.delete(idImmobile);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit", method= RequestMethod.GET)
	public ModelAndView edit(@RequestParam("idImmobile") Long idImmobile, Model model) {
		
		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		ImmobileEntity immobileEntity = this.immobileService.consultById(idImmobile);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobileEntity", immobileEntity);
		
		return new ModelAndView("edit");
	}
	
	@RequestMapping(value= "/saveAlter", method= RequestMethod.POST)
	public ModelAndView saveAlter(@ModelAttribute
								@Valid ImmobileEntity immobileEntity,
								final BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes) {
//		boolean isErrorNullFields = false;
		Boolean bool = false;
		ModelAndView andView = new ModelAndView("/edit");
		if(result.hasErrors()) {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			andView.addObject("owners", ownerEntity);
			
			andView.addObject("immobileEntity", immobileEntity);
			
			return andView;
		} else {
			bool = immobileService.save(immobileEntity);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/consult");
		if(bool == false ) {
			redirectAttributes.addFlashAttribute("msg_result_success", "Registro alterado com sucesso!");
		} else {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			andView.addObject("owners", ownerEntity);
			
			andView.addObject("immobileEntity", immobileEntity);		
			
			andView.addObject("msg_result_fail", "Colisão de endereço, impossivel alterar!");
			
			return andView;
		}

		return modelAndView;
	}
	
	@RequestMapping(value="/search", method= RequestMethod.POST)
	public ModelAndView search(@ModelAttribute SearchForm searchForm, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		List<ImmobileEntity> immobileEntity = this.immobileService.search(searchForm);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobileEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	/* TODA ESSA PARTE REALIZA PESQUISA UM POR UM
	@PostMapping("/searchOwner")
	public ModelAndView searchOwner(@RequestParam("nameSearch") String nameSearch, Model model) {
		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		List<ImmobileEntity> immobileEntity = this.immobileService.searchByOwner(nameSearch);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobileEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	@RequestMapping(value="/searchId", method= RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("idSearch") Long idImmobile, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		if(idImmobile == null) {
			return new ModelAndView("consult");
		}
		ImmobileEntity immobileEntity = this.immobileService.consultById(idImmobile);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobileEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	
	@RequestMapping(value="/searchAdress", method= RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("idAdress") String street, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		List<ImmobileEntity> immobileEntity = this.immobileService.searchByAdress(street);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobileEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	*/
	// FOI SUBSTITUIDO PELO /SEARCH
//	@RequestMapping(value="/search2", method= RequestMethod.POST)
//	public ModelAndView searchTest(@RequestParam("idSearch")Long id,
//			@RequestParam("nameStreet") String street,
//			@RequestParam("nameSearch") String owners,
//			 Model model) {
//
//		List<OwnerEntity> ownerEntity = ownerService.consultType();
//		
//		List<ImmobileEntity> immobileEntity = this.immobileService.search2(id,street,owners);
//			
//		
//		model.addAttribute("owners", ownerEntity);
//		
//		model.addAttribute("immobileEntity", immobileEntity);
//		return new ModelAndView("consult");
//	}
//	
//	@RequestMapping(value= "/report", method= RequestMethod.GET)
//	public void imprimir(@RequestParam Map<String, Object> parametros, HttpServletResponse response) throws JRException, SQLException, IOException {
//
//	}
}