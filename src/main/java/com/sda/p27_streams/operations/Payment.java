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

    public enum PaymentStatus {
        PENDING,
        APPROVED,
        REJECTED
    }


}
