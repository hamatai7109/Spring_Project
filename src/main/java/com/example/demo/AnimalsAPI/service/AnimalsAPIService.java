package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {
	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) throws IOException {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<Animals> getAllAnimals() throws IOException {
		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList);
	}

	public List<Animals> getSelectedAnimal(String animalId) throws IOException {

		Animals[] animal = animalsAPIRepository.selectedAnimal(animalId);

		return Arrays.asList(animal);
	}
}