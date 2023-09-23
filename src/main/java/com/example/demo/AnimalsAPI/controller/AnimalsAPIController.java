package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {
	private final AnimalsAPIService AnimalsAPIService;

	public AnimalsAPIController(AnimalsAPIService AnimalsAPIService) {
		this.AnimalsAPIService = AnimalsAPIService;
	}

	@GetMapping("/animalsSearch")
	public String showTop() throws IOException {
		return "animalsSearch";
	}

	@GetMapping("/animalsDetail")
	public String getData(
			@RequestParam(name = "operator", required = false) Integer operator,
			Model model) throws IOException {

		List<Animals> animal = AnimalsAPIService.getSelectedAnimal(operator);

		model.addAttribute("animalList", animal);

		return "animalsDetail";
	}
}