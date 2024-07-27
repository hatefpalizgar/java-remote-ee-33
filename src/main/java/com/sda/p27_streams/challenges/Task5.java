package com.sda.java.p27_streams.challenges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Task5 {
    public Map<String, Long> groupTransactionsByType(List<Transaction> transactions) {
        Map<String, Long> result = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.counting()));
        return result;
    }

    @Test
    void testGroupTransactionsByType() {
        Transaction t1 = new Transaction(1, "Credit", 100.00);
        Transaction t2 = new Transaction(2, "Debit", 50.00);
        Transaction t3 = new Transaction(3, "Credit", 75.00);
        Transaction t4 = new Transaction(4, "Credit", 200.00);
        Transaction t5 = new Transaction(5, "Debit", 20.00);
        List<Transaction> transactions = Arrays.asList(t1, t2, t3, t4, t5);

        Map<String, Long> expected = new HashMap<>();
        expected.put("Credit", 3L);
        expected.put("Debit", 2L);
        Map<String, Long> actual = groupTransactionsByType(transactions);

        assertEquals(expected, actual);
    }

    static class Transaction {
        private int id;
        private String type;
        private double amount;

        public Transaction(int id, String type, double amount) {
            this.id = id;
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

}

