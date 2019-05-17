package com.projectMoldSystems.immobileProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.projectMoldSystems.immobileProject.repository.ImmobileRepository;
import com.projectMoldSystems.immobileProject.repository.OwnerRepository;
import com.projectMoldSystems.immobileProject.service.ImmobileService;
import com.projectMoldSystems.immobileProject.service.OwnerService;

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
		
		if(result.hasErrors()) {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			model.addAttribute("owners", ownerEntity);
			
			model.addAttribute("immobileEntity", immobileEntity);
			
			return new ModelAndView("/newCadaster");
		}else {
			
			immobileService.save(immobileEntity);
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/newCadaster");
		
		redirectAttributes.addFlashAttribute("msg_result", "Registro salvo com sucesso!");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/consult", method= RequestMethod.GET)
	public ModelAndView consult(Model model) {
		
		model.addAttribute("immobilesEntity", this.immobileService.consultAll());
		
		
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

		if(result.hasErrors()) {
			List<OwnerEntity> ownerEntity = ownerService.consultType();
			
			model.addAttribute("owners", ownerEntity);
			
			model.addAttribute("immobileEntity", immobileEntity);
			
			return new ModelAndView("edit");
		} else {
			
			immobileService.alter(immobileEntity);
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/consult");

		return modelAndView;
	}
	
	@PostMapping("/searchOwner")
	public ModelAndView searchOwner(@RequestParam("nameSearch") String nameSearch, Model model) {
		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		List<ImmobileEntity> immobileEntity = this.immobileService.searchByOwner(nameSearch);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobilesEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	@RequestMapping(value="/searchId", method= RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("idSearch") Long idImmobile, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		List<ImmobileEntity> immobileEntity = this.immobileService.searchById(idImmobile);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobilesEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	
	@RequestMapping(value="/searchAdress", method= RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("idAdress") String street, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		
		List<ImmobileEntity> immobileEntity = this.immobileService.searchByAdress(street);
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobilesEntity", immobileEntity);
		return new ModelAndView("consult");
	}
	
	@RequestMapping(value="/search", method= RequestMethod.POST)
	public ModelAndView search(@RequestParam("search") String number, Model model) {

		List<OwnerEntity> ownerEntity = ownerService.consultType();
		List<ImmobileEntity> immobileEntity = new ArrayList<ImmobileEntity>();
		
		if(number == "1") {
			ImmobileEntity immobileId = new ImmobileEntity();
			Long idImmobile = immobileId.getId();
			immobileEntity = this.immobileService.searchById(idImmobile);
		}
		if(number == "2") {
			immobileEntity = this.immobileService.searchByAdress(number);
		}
		if(number == "3") {
			immobileEntity = this.immobileService.searchByOwner(number);
		}
		
		
		model.addAttribute("owners", ownerEntity);
		
		model.addAttribute("immobilesEntity", immobileEntity);
		return new ModelAndView("consult");
	}
}