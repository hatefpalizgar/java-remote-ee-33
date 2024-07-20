package com.sda.p27_streams.operations;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data // @Getter + @Setter + @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Payment {
    private String id;
    private String customerName;
    private BigDecimal amount; // for monetary values, instead of double, prefer BigDecimal due to precision
    private PaymentStatus status;
    private LocalDate date;

    public Payment(String id, String customerName, BigDecimal amount, PaymentStatus status, LocalDate date) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public boolean isApproved() {
        return status == PaymentStatus.APPROVED;
    }

    public boolean isOverdue() {
        // a payment is overdue if it's in PENDING state and the date of the payment is more than 30 days ago
        return status == PaymentStatus.PENDING && LocalDate.now().isAfter(date.plusDays(30));
    }

    public void approve() {
        this.status = PaymentStatus.APPROVED;
    }

    public void reject() {
        this.status = PaymentStatus.REJECTED;
    }

    public void markAsPending() {
        this.status = PaymentStatus.PENDING;
    }

    public enum PaymentStatus {
        PENDING,
        APPROVED,
        REJECTED
    }


}
