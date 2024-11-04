package com.dummynode.cryptotrackingbackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", length = 29, nullable = false, unique = true)
    private String userId;

    @Column(name = "balance", precision = 19, scale = 2)
    private BigDecimal balance;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    // Default constructor

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

}

