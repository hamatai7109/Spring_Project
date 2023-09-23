package com.example.demo.sampleAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sampleAPI.data.AnimalsDemo;
import com.example.demo.sampleAPI.repository.SampleAPIRepository;

@Service
public class SampleAPIService {
	private final SampleAPIRepository sampleAPIRepository;

	public SampleAPIService(SampleAPIRepository sampleAPIRepository) {
		this.sampleAPIRepository = sampleAPIRepository;
	}

	public List<AnimalsDemo> getAnimals() throws IOException {
		AnimalsDemo[] animalsList = sampleAPIRepository.getAnimals();

		return Arrays.asList(animalsList);
	}
}