package com.said.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {

    @Test
    void shouldAddNumbers() {
        Operation operation = new AddOperation();

        assertEquals(15, operation.execute(10, 5));
    }

    @Test
    void shouldSubtractNumbers() {
        Operation operation = new SubtractOperation();

        assertEquals(5, operation.execute(10, 5));
    }

    @Test
    void shouldMultiplyNumbers() {
        Operation operation = new MultiplyOperation();

        assertEquals(50, operation.execute(10, 5));
    }

    @Test
    void shouldDivideNumbers() {
        Operation operation = new DivideOperation();

        assertEquals(2, operation.execute(10, 5));
    }

    @Test
    void shouldCalculateModulo() {
        Operation operation = new ModuloOperation();

        assertEquals(1, operation.execute(10, 3));
    }
}