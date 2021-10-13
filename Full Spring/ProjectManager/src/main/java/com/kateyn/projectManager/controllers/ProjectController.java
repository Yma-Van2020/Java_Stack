package com.kateyn.projectManager.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kateyn.projectManager.models.Project;
import com.kateyn.projectManager.models.User;
import com.kateyn.projectManager.services.ProjectService;
import com.kateyn.projectManager.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService pServ;
	
	@Autowired
	private UserService uServ;
	
	//====display====
	@GetMapping("projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("user_id"); //make sure the user is logged in
	if(id == null) {
		return "redirect:/"; //if not, redirect to the loginReg page
	}
		
	User lead = uServ.getUserById(id);
		model.addAttribute("leadl",lead);
	return "newProject.jsp";
	}
	
	
	//====actions====
}
