package com.libertymutual.goforcode.timeless.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.timeless.models.TimeSheet;
import com.libertymutual.goforcode.timeless.services.TimeSheetRepository;

@Controller
@RequestMapping("/")
public class TimelessController {
	
	private TimeSheetRepository repository;

	public TimelessController(TimeSheetRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public String showHome() {
		return "timeless/default";
	}
	
//	@GetMapping("timetracker")
//    public ModelAndView list() {
//        ModelAndView mv = new ModelAndView("timeless/default");
//        List<TimeSheet> items = repository.getAll();
//        return mv;
//    }
	
	@PostMapping("timetracker")
    public String create(TimeSheet item) {
        repository.create(item);
        return "redirect:/";
    }

}
