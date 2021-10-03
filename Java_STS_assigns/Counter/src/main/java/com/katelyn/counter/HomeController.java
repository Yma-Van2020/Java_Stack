package com.katelyn.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(HttpSession session) {
    	if(session.getAttribute("count") == null) {
    		session.setAttribute("count", 1);
    	} else {
    		Integer currentCount = (Integer) session.getAttribute("count");
    		currentCount++;
    		session.setAttribute("count", currentCount);
    	}
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String count(HttpSession session, Model model) {
    	Integer currentCount = (Integer) session.getAttribute("count");
    	if(currentCount == null) {
    		currentCount = 0;
    	}
    	model.addAttribute("countDisplay", currentCount);
        return "display.jsp";
    }
    
    @RequestMapping("/count_reset")
	public String resetCount(HttpSession session, Model model) {
		session.setAttribute("count", 0);
		model.addAttribute("countDisplay", session.getAttribute("count"));
		
		return "display.jsp";
	}
}