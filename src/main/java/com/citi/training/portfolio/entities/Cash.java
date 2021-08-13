package com.citi.training.portfolio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="cash")
public class Cash implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="date_time")
    private LocalDateTime dateTime; // Date of transaction
    @Column(name="financial_institution")
    private String financialInstitution; // Name of financial institution
    @Column(name="account_type")
    private int accountType; // Type of account - 0 for chequing, 1 for savings, 2 for cash management, 3 for broker
    @Column(name="transaction_type")
    private int transactionType; // Deposit or withdraw - 0 for deposit, 1 for withdraw
    @Column(name="balance")
    private double balance; // Value of the current account balance
    @Column(name="transaction_amount")
    private double transactionAmount; // Value of the amount in transaction
    @Column(name="account_number")
    private int accountNumber; // Value of the account number

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}

