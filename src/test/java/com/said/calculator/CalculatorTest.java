package com.said.calculator;

import com.said.calculator.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldAdd() {
        assertEquals(15, calculator.calculate(10, 5, "+"));
    }

    @Test
    void shouldSubtract() {
        assertEquals(5, calculator.calculate(10, 5, "-"));
    }

    @Test
    void shouldMultiply() {
        assertEquals(50, calculator.calculate(10, 5, "*"));
    }

    @Test
    void shouldDivide() {
        assertEquals(2, calculator.calculate(10, 5, "/"));
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.calculate(10, 0, "/")
        );
    }
}