package com.sda.p27_streams.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {
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


        // count() is a terminal operation that returns the number of stream elements
        payments.stream()
                .count();

        // forEach() is a terminal operation that performs an action for each element in the stream
        payments.stream()
                .forEach(p -> System.out.println(p.getCustomerName() + ":" + p.getAmount()));

        // max() is a terminal operation that returns the maximum element of the stream, according to
        // a provided comparator
        Optional<Payment> maxPaymentOpt = payments.stream()
                .max(Comparator.comparing(p -> p.getAmount()));
        maxPaymentOpt.ifPresent(p -> System.out.println("Maximum payment: " + p.getAmount())); // print payment with ID 2

        // reduce() is a terminal operation that reduces the elements of the stream to a single value
        // according to a given binary operator
        Optional<BigDecimal> totalOpt = payments.stream()
                .map(p -> p.getAmount())
                .reduce((amount1, amount2) -> amount1.add(amount2));
        totalOpt.ifPresent(total -> System.out.println("Total amount: " + total)); // Total amount: 576.50
    }
}
