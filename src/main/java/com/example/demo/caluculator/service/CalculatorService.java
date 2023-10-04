package com.example.demo.caluculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public Result calculator(Integer firstNum, Integer secondNum, String operator) {
		int result = 0;
		String errorMessage = null;

		switch (operator) {
		case "add":
			result = firstNum + secondNum;
			break;
		case "subtract":
			result = firstNum - secondNum;
			break;
		case "multiply":
			result = firstNum * secondNum;
			break;
		case "divide":
			if (secondNum != 0) {
				result = firstNum / secondNum;
			} else {
				errorMessage = "0で割ることはできません。";
			}
			break;
		default:
			errorMessage = "演算子が正しく選択されていません。";
		}

		return new Result(result, errorMessage);
	}

	public class Result {
		private final int result;
		private final String errorMessage;

		public Result(int result, String errorMessage) {
			this.result = result;
			this.errorMessage = errorMessage;
		}

		public int getResult() {
			return result;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
	}
}
