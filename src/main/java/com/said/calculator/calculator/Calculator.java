package com.said.calculator.calculator;

import com.said.calculator.operations.Operation;
import com.said.calculator.operations.AddOperation;
import com.said.calculator.operations.DivideOperation;
import com.said.calculator.operations.ModuloOperation;
import com.said.calculator.operations.SubtractOperation;
import com.said.calculator.operations.MultiplyOperation;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operations = new HashMap<>();

    public Calculator() {
        operations.put("+", new AddOperation());
        operations.put("-", new SubtractOperation());
        operations.put("*", new MultiplyOperation());
        operations.put("/", new DivideOperation());
        operations.put("%", new ModuloOperation());
    }
    public double calculate(double a, double b, String operator) {

        Operation operation = operations.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException("Неизвестный оператор");
        }

        return operation.execute(a, b);
    }
}
