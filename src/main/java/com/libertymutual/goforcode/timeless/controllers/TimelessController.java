package com.libertymutual.goforcode.timeless.controllers;

import java.util.ArrayList;
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
	
	private String buttonChoice = "update";
	private double sum = 0.0;
	private ArrayList<Double> hours;
	private TimeSheetRepository repository;
	private String date = "mm/dd/yyyy";

	public TimelessController(TimeSheetRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public String showDefaultPageRedirect() {
		return "redirect:/timetracker";
	}
	
	@GetMapping("timetracker")
	public ModelAndView getTimeSheet() {
		ModelAndView mv = new ModelAndView("timeless/default");
		List<TimeSheet> item = new ArrayList<TimeSheet>();        
		TimeSheet week = new TimeSheet();
		week = repository.getTempFileOfWeeks();
		
		if (buttonChoice == "update") {
			hours = week.getAllHours();
			date = week.getDate();
			sum = week.getSum();
		}
			
		item = repository.getFileOfWeeks();
        mv.addObject("timeItemList", item);
        mv.addObject("hasTimeItemListOfHours", !item.isEmpty());
		mv.addObject("date", date);
		mv.addObject("sum", sum);
		mv.addObject("monday", hours.get(0));
		mv.addObject("tuesday", hours.get(1));
		mv.addObject("wednesday", hours.get(2));
		mv.addObject("thursday", hours.get(3));
		mv.addObject("friday", hours.get(4));
		return mv;
	}
	
	@PostMapping("timetracker")
    public ModelAndView updateTimeSheet(TimeSheet item, String button) {
		ModelAndView mv = new ModelAndView("redirect:/timetracker");
		if (button.equals("update")) {
			buttonChoice = "update";
			repository.writeTempWeekToFile(item);
			date = item.getDate();
			sum = item.getSum();
			hours = item.getAllHours();
			return mv;
		}
		else {
			buttonChoice = "submit";
			repository.writeWeekToFile(item);
			date = "mm/dd/yyyy";
			sum = 0.0;
			hours.set(0, 0.0);
			hours.set(1, 0.0);
			hours.set(2, 0.0);
			hours.set(3, 0.0);
			hours.set(4, 0.0);
			return mv;
		}
    }

}
