/* Clear ACCOUNTS */
DELETE FROM TRANSACTIONS;

DELETE FROM ACCOUNTS;

/* Insert ACCOUNTS */
INSERT INTO
    ACCOUNTS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE
    )
VALUES (
        1, 'Joao - User', 12345678900, 'joao@test.com', '123456', 1, 1000.00
    );

INSERT INTO
    ACCOUNTS (
        ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE
    )
VALUES (
        2, 'Maria - Lojista', 12345678901, 'maria@test.com', '123456', 2, 1000.00
    );

INSERT INTO
    TRANSACTIONS(ID, SENDER, RECIPIENT, "VALUE", CREATED_AT)
    VALUES
    (1, 1, 2, 300.0, CURRENT_TIMESTAMP)