package com.projectMoldSystems.immobile.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectMoldSystems.immobile.model.ImmobileModel;
import com.projectMoldSystems.immobile.model.OwnerModel;
import com.projectMoldSystems.immobile.model.TypeImmobileModel;
import com.projectMoldSystems.immobile.service.ImmobileService;
import com.projectMoldSystems.immobile.service.OwnerService;
import com.projectMoldSystems.immobile.service.TypeImmobileService;

@Controller
public class ImmobileController {
	
	@Autowired
	private TypeImmobileService typeService;
	
	@Autowired
	private ImmobileService immobileService;
	
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping(value="/newCadaster", method= RequestMethod.GET)
	public ModelAndView newCadaster(Model model) {
		
		model.addAttribute("types", typeService.consultType());
		
		model.addAttribute("owners", ownerService.consultType());
		
		model.addAttribute("immobileModel", new ImmobileModel());
		
		return new ModelAndView("newCadaster");
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView saveImmobile(@ModelAttribute
									@Valid ImmobileModel immobileModel,
									final BindingResult result,
									Model model,
									RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			List<TypeImmobileModel> typeModel = typeService.consultType();
			List<OwnerModel> ownerModel = ownerService.consultType();
			
			typeModel.forEach(type ->{
				
				if(immobileModel.getTypes() != null && immobileModel.getTypes().size() > 0) {
					
					immobileModel.getTypes().forEach(typeSelect->{
						if(typeSelect!= null) {
							if(type.getId().equals(typeSelect))
								type.setChecked(true);
						}
					});
					
				}
				
				
			});
			
			ownerModel.forEach(owner ->{
					if(immobileModel.getOwners() != null && immobileModel.getOwners().size() > 0) {
					
					immobileModel.getOwners().forEach(ownerSelect->{
						if(ownerSelect!= null) {
							if(owner.getId().equals(ownerSelect))
								owner.setCheckedOwner(true);
						}
					});
					
				}
			});
			model.addAttribute("types", typeModel);
			 
			model.addAttribute("owners", ownerModel);
			
			model.addAttribute("immobileModel", immobileModel);
			
			return new ModelAndView("/newCadaster");
		}else {
			
			immobileService.save(immobileModel);
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/newCadaster");
		
		redirectAttributes.addFlashAttribute("msg_result", "Registro salvo com sucesso!");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/consult", method= RequestMethod.GET)
	public ModelAndView consult(Model model) {
		
		model.addAttribute("immobilesModel", this.immobileService.consultAll());
		
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
		
		List<TypeImmobileModel> typeModel = typeService.consultType();
		List<OwnerModel> ownerModel = ownerService.consultType();
		
		ImmobileModel immobileModel = this.immobileService.consultById(idImmobile);
		
		typeModel.forEach(type ->{
			
			if(immobileModel.getTypes() != null && immobileModel.getTypes().size() > 0) {
				
				immobileModel.getTypes().forEach(typeSelect->{
					if(typeSelect!= null) {
						if(type.getId().equals(typeSelect))
							type.setChecked(true);
					}
				});
			}
			
		});
		
		ownerModel.forEach(owner ->{
			if(immobileModel.getOwners() != null && immobileModel.getOwners().size() > 0) {
			
			immobileModel.getOwners().forEach(ownerSelect->{
				if(ownerSelect!= null) {
					if(owner.getId().equals(ownerSelect))
						owner.setCheckedOwner(true);
					}
				});
			
			}
		});
		model.addAttribute("types", typeModel);
		
		model.addAttribute("owners", ownerModel);
		
		model.addAttribute("immobileModel", immobileModel);
		
		return new ModelAndView("edit");
	}
	
	@RequestMapping(value= "/saveAlter", method= RequestMethod.POST)
	public ModelAndView saveAlter(@ModelAttribute
								@Valid ImmobileModel immobileModel,
								final BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes) {
		boolean isErrorNullFields = false;

		if(isErrorNullFields) {
			List<TypeImmobileModel> typeModel = typeService.consultType();
			List<OwnerModel> ownerModel = ownerService.consultType();
			
			typeModel.forEach(type ->{
				
				if(immobileModel.getTypes() != null && immobileModel.getTypes().size() > 0) {
					
					immobileModel.getTypes().forEach(typeSelect->{
						if(typeSelect!= null) {
							if(type.getId().equals(typeSelect))
								type.setChecked(true);
						}
					});
				}
				
			});
			
			ownerModel.forEach(owner ->{
				if(immobileModel.getOwners() != null && immobileModel.getOwners().size() > 0) {
				
				immobileModel.getOwners().forEach(ownerSelect->{
					if(ownerSelect!= null) {
						if(owner.getId().equals(ownerSelect))
							owner.setCheckedOwner(true);
						}
					});
				
				}
			});
			model.addAttribute("types", typeModel);
			
			model.addAttribute("owners", ownerModel);
			
			model.addAttribute("immobileModel", immobileModel);
			
			return new ModelAndView("edit");
		} else {
			
			immobileService.alter(immobileModel);
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/consult");

		return modelAndView;
	}
}
