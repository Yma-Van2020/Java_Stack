package com.katelyn.daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	@RequestMapping("")
	public String greeting() {
		return "Welcome!";

	}
	
	@RequestMapping("/today")
		public String today() {
			return "Today you will find luck in all your endeavors!";
		}
	
	@RequestMapping("/tomorrow")
	   public String tmr() {
		return "Torrow, and opportinity will arise, so be sire to be open";
	}

}

