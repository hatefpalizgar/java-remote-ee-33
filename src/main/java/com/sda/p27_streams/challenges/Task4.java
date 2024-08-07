package com.sda.java.p27_streams.challenges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Task4 {
    public List<Product> sortProducts(List<Product> products) {
        List<Product> result = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()
                        .thenComparing(Product::getName))
                .collect(Collectors.toList());
        return result;
    }

    @Test
    void testSortProducts() {
        Product p1 = new Product("Laptop", 1200.00, 10);
        Product p2 = new Product("Speaker", 300.00, 50);
        Product p3 = new Product("Keyboard", 500.00, 20);
        Product p4 = new Product("Monitor", 300.00, 5);
        List<Product> products = Arrays.asList(p1, p2, p3, p4);

        List<Product> expected = Arrays.asList(p1, p3, p4, p2);
        List<Product> actual = sortProducts(products);

        assertEquals(expected, actual);
    }

    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    '}';
        }
    }

}

