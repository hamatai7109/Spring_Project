package com.example.demo.caluculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public Object[] calculator(Integer firstNum, Integer secondNum, String operator) {
		String result = null;
		String errorMessage = null;

		switch (operator) {
		case "add":
			result = String.valueOf(firstNum + secondNum);
			break;
		case "subtract":
			result = String.valueOf(firstNum - secondNum);
			break;
		case "multiply":
			result = String.valueOf(firstNum * secondNum);
			break;
		case "divide":
			if (secondNum != 0) {
				result = String.valueOf(firstNum / secondNum);
			} else {
				errorMessage = "0で割ることはできません。";
			}
			break;
		default:
			errorMessage = "演算子が正しく選択されていません。";
		}

		return new Object[] { result, errorMessage };
	}
}
