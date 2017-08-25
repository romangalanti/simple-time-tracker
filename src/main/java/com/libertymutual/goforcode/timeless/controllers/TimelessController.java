package com.libertymutual.goforcode.timeless.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TimelessController {
	
	public TimelessController() {
		
	}
	
	@GetMapping("")
	public String showHome() {
		return "timeless/default";
	}

}
