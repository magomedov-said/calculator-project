package com.said.calculator.operations;

public class ModuloOperation implements Operation {
    @Override
    public double execute(double a, double b) {
        return a % b;
    }
}
