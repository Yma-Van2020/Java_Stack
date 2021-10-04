package com.katelyn.omikuji;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/omikuji")
	public String omikuji() {
		
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(
			HttpSession session,
			@RequestParam(value="number") String number,
			@RequestParam(value="cityName") String cityName,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="endeavorHobby") String endeavorHobby,
			@RequestParam(value="living") String living,
			@RequestParam(value="nice") String nice) {
		
			session.setAttribute("number", number);
			session.setAttribute("cityName", cityName);
			session.setAttribute("personName", personName);
			session.setAttribute("endeavorHobby", endeavorHobby);
			session.setAttribute("living", living);
			session.setAttribute("nice", nice);
			System.out.println(session);
			
			return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("cityName", session.getAttribute("cityName"));
		model.addAttribute("personName", session.getAttribute("personName"));
		model.addAttribute("endeavorHobby", session.getAttribute("endeavorHobby"));
		model.addAttribute("living", session.getAttribute("living"));
		model.addAttribute("nice", session.getAttribute("nice"));
		return "display.jsp";
	}
			
}