package com.sda.p27_streams.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {
    public static void main(String[] args) {

        List<Payment> payments = Arrays.asList(
                new Payment(
                        "1",
                        "John",
                        new BigDecimal("100.50"),
                        Payment.PaymentStatus.APPROVED,
                        LocalDate.now()),
                new Payment(
                        "2",
                        "Mary",
                        new BigDecimal("200.75"),
                        Payment.PaymentStatus.PENDING,
                        LocalDate.now().minusDays(60)),
                new Payment(
                        "3",
                        "John",
                        new BigDecimal("50.00"),
                        Payment.PaymentStatus.APPROVED,
                        LocalDate.now()),
                new Payment(
                        "4",
                        "Bob",
                        new BigDecimal("150.25"),
                        Payment.PaymentStatus.APPROVED,
                        LocalDate.now()),
                new Payment(
                        "5",
                        "Mary",
                        new BigDecimal("75.00"),
                        Payment.PaymentStatus.PENDING,
                        LocalDate.now().minusDays(15)));

        System.out.println("=================== filter() =====================");

        // filter() to get only the approved payments
        payments.stream()
                .filter(p -> p.isApproved())  // filter is an intermediate operation
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());

        // filter() to get only the approved payments by John
        payments.stream()
                .filter(p -> p.isApproved())
                .filter(p -> p.getCustomerName().equals("John"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== map() =====================");

        // map() to transform the payment objects into their amount
        payments.stream()
                .map(p -> p.getAmount())
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== sorted() =====================");

        // sorted() to sort the payments by their amount
        payments.stream()
                .sorted(Comparator.comparing(p -> p.getAmount()))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== distinct() =====================");
        // distinct() to get the unique customer names
        payments.stream()
                .map(p -> p.getCustomerName())
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== limit() =====================");
        // limit() to get the first two payments made by Mary
        payments.stream()
                .filter(p -> p.getCustomerName().equals("Mary"))
                .limit(2)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== skip() =====================");
        // skip() to get the second payment made by Mary
        payments.stream()
                .filter(p -> p.getCustomerName().equals("Mary"))
                .skip(1)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("=================== dropWhile() =====================");
        // dropWhile(): while a payment amount is between 90 and 120, discard it
        payments.stream()
                .dropWhile(p -> p.getAmount().intValue() > 50 && p.getAmount().intValue() < 120)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
