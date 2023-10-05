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
	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("/animalsSearch")
	public String showTop(Model model) throws IOException {
		List<Animals> animalsList = animalsAPIService.getAllAnimals();

		model.addAttribute("animalsList", animalsList);

		return "animalsSearch";
	}

	@GetMapping("/animalsDetail")
	public String getData(
			@RequestParam(name = "animalId", required = false) String animalId,
			Model model) throws IOException {

		List<Animals> animalList = animalsAPIService.getSelectedAnimal(animalId);

		model.addAttribute("animalList", animalList);

		return "animalsDetail";
	}
}