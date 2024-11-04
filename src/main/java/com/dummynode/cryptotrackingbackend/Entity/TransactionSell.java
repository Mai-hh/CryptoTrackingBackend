package com.dummynode.cryptotrackingbackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction_sell")
public class TransactionSell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "deal_price", precision = 19, scale = 2)
    private BigDecimal dealPrice;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    @Override
    public String toString() {
        return "TransactionSell{" +
                "transactionId=" + transactionId +
                ", user=" + user +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", dealPrice=" + dealPrice +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}