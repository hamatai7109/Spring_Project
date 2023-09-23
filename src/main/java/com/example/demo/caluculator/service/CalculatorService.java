package com.example.demo.caluculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService { 
	public int calculator(int firstNum, int secondNum, String operator) {
		int result = 0;
		switch(operator) {
		case "add":
			result =  firstNum + secondNum;
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
                throw new ArithmeticException("0で割ることはできません。");
            }
            break;
        default:
        	throw new ArithmeticException("演算子が正しく選択されていません。");		}
		return result;
	}
}