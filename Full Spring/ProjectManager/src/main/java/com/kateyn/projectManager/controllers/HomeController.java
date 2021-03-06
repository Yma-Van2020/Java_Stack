package com.kateyn.projectManager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kateyn.projectManager.models.LoginUser;
import com.kateyn.projectManager.models.Project;
import com.kateyn.projectManager.models.User;
import com.kateyn.projectManager.services.ProjectService;
import com.kateyn.projectManager.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;

	@Autowired
	private ProjectService pServ;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/home";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		userServ.register(newUser,  result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(("user_id"));
		
		return "redirect:/";
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long id = (Long) session.getAttribute("user_id");
		User user = userServ.getUserById(id);
		List<Project> allProjects = pServ.getAllProjects();
	
		
		model.addAttribute("allProjects", allProjects);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
}







