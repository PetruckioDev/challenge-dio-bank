package com.petruckio.desafio_dio_banco.transaction;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;

@Table("TRANSACTIONS")
public record Transaction(
        @Id
        Long id,
        Long sender,
        Long recipient,
        BigDecimal value,
        Instant createdAt
) {

    public Transaction {
        value = value.setScale(2);
        createdAt = Instant.now(Clock.systemUTC());
    }
}
