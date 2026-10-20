package com.said.calculator;

import com.said.calculator.history.HistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HistoryManagerTest {

    @BeforeEach
    void setUp() {
        HistoryManager.clear();
    }

    @Test
    void shouldAddOperation() {
        HistoryManager.add("2 + 3 = 5");

        String history = HistoryManager.history();

        assertTrue(history.contains("1) 2 + 3 = 5"));
    }

    @Test
    void shouldShowLastOperation() {
        HistoryManager.add("2 + 3 = 5");

        String last = HistoryManager.last();

        assertEquals("2 + 3 = 5", last);
    }

    @Test
    void shouldShowEmptyHistory() {
        String last = HistoryManager.last();

        assertEquals("История пуста", last);
    }

    @Test
    void shouldClearHistory() {
        HistoryManager.add("2 + 3 = 5");

        HistoryManager.clear();

        assertEquals("История пуста", HistoryManager.last());
    }

    @Test
    void shouldShowOnlyLastTenOperations() {
        for (int i = 1; i <= 11; i++) {
            HistoryManager.add("Операция " + i);
        }

        String history = HistoryManager.history();

        assertTrue(history.contains("2) Операция 2"));
        assertTrue(history.contains("11) Операция 11"));
        assertTrue(!history.contains("1) Операция 1\n"));
    }
}

