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
		String errorMessage = null;

		if (firstNum != null && secondNum != null && operator != null) {
			Object[] calculationResult = calculatorService.calculator(firstNum, secondNum, operator);
			if (calculationResult[0] != null) {
				result = (String) calculationResult[0];
			}
			if (calculationResult[1] != null) {
				errorMessage = (String) calculationResult[1];
			}
		}
		model.addAttribute("result", result);
		model.addAttribute("errorMessage", errorMessage);
		return "calculator";
	}
}