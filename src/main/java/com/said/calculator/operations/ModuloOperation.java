package com.said.calculator.operations;

public class ModuloOperation implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a % b;
    }
}
