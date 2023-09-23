package com.example.demo.minus.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;


@Controller
public class MinusController {
	private final MinusService minusService;
	
	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}
	
	@GetMapping("minus")
	public String minus(
			@RequestParam(name = "firstNum", required = false) Integer firstNum,
			@RequestParam(name = "secondNum", required = false) Integer secondNum,
			Model model
			) {
		    if (firstNum != null && secondNum != null) {
		        int result = minusService.minus(firstNum, secondNum);
		        model.addAttribute("result", result);
		    } else {
		        // Handle the case when one or both parameters are missing
		        model.addAttribute("error", "Both 'firstNum' and 'secondNum' parameters are required.");
		    }
		return "minus";
	}
	
}