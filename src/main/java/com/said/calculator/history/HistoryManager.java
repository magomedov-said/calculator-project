package com.said.calculator.history;

import java.util.ArrayList;

public class HistoryManager {

    public static ArrayList<String> operations = new ArrayList<>();

    public static void add(String operation) {
        if (operations.size() >= 10) {
            operations.remove(0);
        }

        operations.add(operation);
    }

    public static String history() {
        if (operations.isEmpty()) {
            return "История пуста";
        }

        String result = "";

        int start = Math.max(0, operations.size() - 10);

        for (int i = start; i < operations.size(); i++) {
            result += (i + 1) + ") " + operations.get(i) + "\n";
        }

        return result;
    }

    public static String last() {
        if (operations.isEmpty()) {
            return "История пуста";
        }

        return operations.get(operations.size() - 1);
    }

    public static void clear() {
        operations.clear();
    }

    public static String help() {
        return """
                Доступные команды:

                <число> <оператор> <число>

                Операторы:
                +  сложение
                -  вычитание
                *  умножение
                /  деление

                Команды:
                history  — история
                last     — последняя операция
                clear    — очистить историю
                exit     — выход
                """;
    }
}
