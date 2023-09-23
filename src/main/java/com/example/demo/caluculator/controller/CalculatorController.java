package com.example.demo.caluculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.caluculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	@GetMapping("/calculator")
	public String calculator(
			@RequestParam(name = "firstNum", required = false) Integer firstNum,
			@RequestParam(name = "secondNum", required = false) Integer secondNum,
			@RequestParam(name = "operator", required = false) String operator,
			Model model) {
			String result = "";
			String errorMessage = ""; 
		    if (firstNum == null || secondNum == null || operator == null) {
		        errorMessage = "値を入れてください";
		    } else {
		        result = String.valueOf(calculatorService.calculator(firstNum, secondNum, operator));
		    }
	        model.addAttribute("result", result);    
	        model.addAttribute("errorMessage", errorMessage);
		return "calculator";
	}
}