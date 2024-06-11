package com.petruckio.desafio_dio_banco.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(name = "ACCOUNTS")
public class Account {
    @Id
    private Long id;
    private String fullName;
    private Long cpf;
    private String email;
    private String password;
    private int type;
    private BigDecimal balance;

    public Account() {
    }

    public Account(Long id, String fullName, Long cpf, String email, String password, int type, BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.type = type;
        this.balance = balance;
    }

    public void withdrawn(BigDecimal value) {
        balance = balance.subtract(value);
    }

    public void deposit(BigDecimal value) {
        balance = balance.add(value);
    }

    public void transfer(BigDecimal value, Account recipient) {
        recipient.deposit(value);
        withdrawn(value);
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
