package com.example.demo.sampleAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.AnimalsDemo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SampleAPIRepository {
	public AnimalsDemo[] getAnimals() throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AnimalsDemo[] animalList = mapper.readValue(json, AnimalsDemo[].class);

		return animalList;
	}
}