package com.katelyn.ninjadojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.katelyn.ninjadojos.models.Ninja;
import com.katelyn.ninjadojos.services.DojoServ;
import com.katelyn.ninjadojos.services.NinjaServ;

@Controller
public class NinjaController {
	@Autowired
	private NinjaServ ninjaServ;
	
	@Autowired
	private DojoServ dojoServ;
	
	// ========== Display =======================
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		
		return "ninjas/new_ninja.jsp";
	}
	
    // ========== Action ========================
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.getAll());
			
			return "ninjas/new_ninja.jsp";
		} else {
			ninjaServ.save(ninja);
			return "redirect:/dashboard";
		}
	}
}

