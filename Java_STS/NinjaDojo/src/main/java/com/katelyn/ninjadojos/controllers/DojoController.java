package com.katelyn.ninjadojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.katelyn.ninjadojos.models.Dojo;
import com.katelyn.ninjadojos.services.DojoServ;

@Controller
public class DojoController {
	@Autowired
	private DojoServ serv;
	
	
	// ========== Display =======================
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allDojos", serv.getAll());
		
		return "display_dojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", serv.getOne(id));
		
		return "one_dojo.jsp";
	}
	
	
    // ========== Action ========================
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "new_dojo.jsp";
		} else {
			serv.save(dojo);
			
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/dojos/{id}/delete")
	public String deleteDojo(@PathVariable("id") Long id) {
		serv.delete(id);
		
		return "redirect:/dashboard";
	}
}
