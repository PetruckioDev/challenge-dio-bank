package com.petruckio.desafio_dio_banco.account;

public enum AccountType {
    CHECKING(1),
    SAVING(2);

    private final int value;

    AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
