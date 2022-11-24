package com.skypro.calculator.service;

import com.skypro.calculator.exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private int sum;

    public String hello(){
        return "Добро пожаловать в калькулятор";
    }

    public String printPlus(int num1, int num2){
        sum = num1 + num2;
        return num1 + " + " + num2 + " = " + sum;
    }

    public String printMinus(int num1, int num2){
        sum = num1 - num2;
        return num1 + " - " + num2 + " = " + sum;
    }


    public String printMultiply(int num1, int num2){
        sum = num1 * num2;
        return num1 + " * " + num2 + " = " + sum;
    }

    public String printDivide(int num1, int num2){
        if(num2 == 0){
            throw new IllegalNumberException("На ноль делить нельзя");
        }
        sum = num1 / num2;
        return num1 + " / " + num2 + " = " + sum;
    }

}
