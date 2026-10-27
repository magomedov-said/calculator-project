package com.said.calculator;

import com.said.calculator.calculator.Calculator;
import com.said.calculator.history.HistoryManager;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static double lastA;
    private static double lastB;
    private static String lastOperator;
    private static boolean hasLast = false;

    public static void main(String[] args) {
        run(scanner);
    }

    public static void run(Scanner scanner) {

        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("Введите пример: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("history")) {
                System.out.println(HistoryManager.history());
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                HistoryManager.clear();
                hasLast = false;
                continue;
            }

            if (input.equalsIgnoreCase("help")) {
                help();
                continue;

            }

            if (input.equalsIgnoreCase("last")) {

                if (hasLast) {
                    double result = calculator.calculate(
                            lastA, lastB, lastOperator
                    );

                    String operation = lastA + " " + lastOperator
                            + " " + lastB + " = " + result;

                    System.out.println(operation);
                    HistoryManager.add(operation);

                } else {
                    System.out.println("Нет последней операции");
                }

                continue;
            }

            calculate(input, calculator);
        }

        scanner.close();
    }


    private static void calculate(String input, Calculator calculator) {

        input = input.trim();

        int operatorIndex = -1;

        for (int i = 1; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '+' || symbol == '-' ||
                    symbol == '*' || symbol == '/' ||
                    symbol == '%') {

                operatorIndex = i;
                break;
            }
        }

        if (operatorIndex == -1) {
            System.out.println("Ошибка формата");
            return;
        }

        String firstNumber = input.substring(0, operatorIndex).trim();
        String operator = input.substring(operatorIndex, operatorIndex + 1);
        String secondNumber = input.substring(operatorIndex + 1).trim();

        try {
            double a = Double.parseDouble(firstNumber);
            double b = Double.parseDouble(secondNumber);

            double result = calculator.calculate(a, b, operator);

            lastA = a;
            lastB = b;
            lastOperator = operator;
            hasLast = true;

            String operation = a + " " + operator + " "
                    + b + " = " + result;

            System.out.println(operation);

            HistoryManager.add(operation);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректные числа");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void help() {
        System.out.println("Доступные операции: +, -, *, /, %");
        System.out.println("history - история вычислений");
        System.out.println("last - повтор последней операции");
        System.out.println("clear - очистить историю");
        System.out.println("help - справка");
        System.out.println("exit - выход");
    }

}
