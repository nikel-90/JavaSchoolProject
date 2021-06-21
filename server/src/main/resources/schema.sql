DROP TABLE IF EXISTS Cards;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Users;

CREATE TABLE users (
    id IDENTITY PRIMARY KEY,
    surname VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    phoneNumber VARCHAR NOT NULL,
    age CHAR(2) NOT NULL,
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

CREATE TABLE accounts (
    id IDENTITY PRIMARY KEY,
    accountNumber CHAR(20) NOT NULL,
    accountBalance DECIMAL(30, 4) DEFAULT 0 NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cards (
    id IDENTITY PRIMARY KEY,
    cardNumber CHAR(16),
    expirationDate DATE,
    PIN CHAR(3),
    CVV CHAR(3),
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);