package com.citi.training.portfolio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name="bonds")
public class Bond implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date_time")
    private LocalDateTime dateTime; // Date of transaction
    @Column(name="symbol")
    private String symbol; // Ticker symbol of investment
    @Column(name="name")
    private String name; // Name of investment
    @Column(name="transaction_type")
    private int transactionType; // Sold or purchased - 0 for buy, 1 for sell
    @Column(name="quantity_affected")
    private int quantityAffected; // How many were sold/purchased
    @Column(name="total_quantity")
    private int totalQuantity; // Total amount of investment
    @Column(name="market_value")
    private double marketValue; // Value of investment at time of transaction
    @Column(name="total_value")
    private double totalValue; // Total value of the investment at this point

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantityAffected() {
        return quantityAffected;
    }

    public void setQuantityAffected(int quantityAffected) {
        this.quantityAffected = quantityAffected;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
