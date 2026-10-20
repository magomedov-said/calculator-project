package com.said.calculator;

import com.said.calculator.calculator.Calculator;
import com.said.calculator.history.HistoryManager;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

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

            if (input.equalsIgnoreCase("last")) {
                System.out.println(HistoryManager.last());
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                HistoryManager.clear();
                continue;
            }

            if (input.equalsIgnoreCase("help")) {
                System.out.println(HistoryManager.help());
                continue;
            }

            calculate(input, calculator);
        }

        scanner.close();
    }


    private static void calculate(String input, Calculator calculator) {

        String[] parts = input
                .replaceAll("([+*/-])", " $1 ")
                .trim()
                .split("\\s+");

        if (parts.length != 3) {
            System.out.println("Ошибка: формат должен быть <число> <оператор> <число>");
            return;
        }

        try {
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[2]);

            double result = calculator.calculate(a, b, parts[1]);

            System.out.println("Результат: " + result);

            HistoryManager.add(
                    a + " " + parts[1] + " " + b + " = " + result
            );

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректные числа");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
