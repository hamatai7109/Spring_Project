package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {
	private final AnimalsAPIRepository AnimalsAPIRepository;
	private List<Animals> animalsList;

	public AnimalsAPIService(AnimalsAPIRepository AnimalsAPIRepository) throws IOException {
		this.AnimalsAPIRepository = AnimalsAPIRepository;
		this.animalsList = Arrays.asList(AnimalsAPIRepository.getAnimals());
	}

	public List<Animals> getAllAnimals() throws IOException {
		return animalsList;
	}

	public List<Animals> getSelectedAnimal(Integer operator) throws IOException {

		Animals[] animal = AnimalsAPIRepository.selectedAnimal(operator);

		return Arrays.asList(animal);
	}
}