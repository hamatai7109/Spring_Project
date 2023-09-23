package com.example.demo.fizzBuzz.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	
	List<String> list = new ArrayList<>();
	
	public List<String> fizzBuzz() {
		for(int i = 1; i <= 100; i++){
			if(i % 3 ==0 && i % 5 ==0){
				list.add("FizzBuzz");
			}else if(i % 3 ==0){
				list.add("Fizz");
			}else if(i % 5 == 0){
				list.add("Buzz");
			}else {
				list.add(Integer.toString(i));
			}
		}
		return list;
	}
}