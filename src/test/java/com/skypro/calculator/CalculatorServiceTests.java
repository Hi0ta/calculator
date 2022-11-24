package com.skypro.calculator;

import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTests {

    private final CalculatorService calculatorService = new CalculatorService();

//    @Test
//    public void checkingHello() {
//        assertEquals("Добро пожаловать в калькулятор", calculatorService.hello());
//    }
//    А есть ли существенная разница между написанием как в этом варианте и вариантом ниже? Если есть, то в чем она состоит?

    @Test
    public void checkingHello() {
        String result = calculatorService.hello();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    public void checkingPlus() {
        String result = calculatorService.printPlus(5, 5);
        assertEquals("5 + 5 = 10", result);
    }

    @ParameterizedTest
    @MethodSource("argumentsForTestPlus")
    public void TestPlus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.printPlus(num1, num2));
    }

    public static List<Arguments> argumentsForTestPlus() {
        return List.of(
                Arguments.of(5, 5, "5 + 5 = 10"),
                Arguments.of(-1, -2, "-1 + -2 = -3"),
                Arguments.of(0, 0, "0 + 0 = 0")
        );
    }

    @Test
    public void checkingMinus() {
        String result = calculatorService.printMinus(5, 5);
        assertEquals("5 - 5 = 0", result);
    }

    @ParameterizedTest
    @MethodSource("argumentsForTestMinus")
    public void TestMinus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.printMinus(num1, num2));
    }

    public static List<Arguments> argumentsForTestMinus() {
        return List.of(
                Arguments.of(5, 5, "5 - 5 = 0"),
                Arguments.of(-1, -2, "-1 - -2 = 1"),
                Arguments.of(0, 0, "0 - 0 = 0")
        );
    }

    @Test
    public void checkingMultiply() {
        String result = calculatorService.printMultiply(5, 5);
        assertEquals("5 * 5 = 25", result);
    }

    @ParameterizedTest
    @MethodSource("argumentsForTestMultiply")
    public void TestMultiply(int num1, int num2, String result) {
        assertEquals(result, calculatorService.printMultiply(num1, num2));
    }

    public static List<Arguments> argumentsForTestMultiply() {
        return List.of(
                Arguments.of(5, 5, "5 * 5 = 25"),
                Arguments.of(-2, -3, "-2 * -3 = 6"),
                Arguments.of(-2, 4, "-2 * 4 = -8"),
                Arguments.of(0, 0, "0 * 0 = 0")
        );
    }

    @Test
    public void checkingDivide() {
        String result = calculatorService.printDivide(5, 5);
        assertEquals("5 / 5 = 1", result);
    }

    @ParameterizedTest
    @MethodSource("argumentsForTestDivide")
    public void TestDivide(int num1, int num2, String result) {
        assertEquals(result, calculatorService.printDivide(num1, num2));
    }

    public static List<Arguments> argumentsForTestDivide() {
        return List.of(
                Arguments.of(5, 5, "5 / 5 = 1"),
                Arguments.of(-6, -3, "-6 / -3 = 2"),
                Arguments.of(-8, 4, "-8 / 4 = -2"),
                Arguments.of(0, 1, "0 / 1 = 0")
        );
    }

    @Test
    public void checkingDivideOnZero() {
        assertThrows(IllegalNumberException.class, () -> calculatorService.printDivide(5, 0));
    }

}

