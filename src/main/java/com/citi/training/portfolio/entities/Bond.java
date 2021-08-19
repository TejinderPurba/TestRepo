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
    @Column(name="issuer")
    private String issuer; // Issuer of the bond
    @Column(name="name")
    private String name; // Name of the bond, unique in database
    @Column(name="bond_type")
    private String bondType; // We only consider Fixed-rate bonds here
    @Column(name="transaction_type")
    private int transactionType; // 0 for buy, 1 for sell, 2 for coupon paid
    @Column(name="face_value")
    private double faceValue; // face value of a bond
    @Column(name="maturity")
    private LocalDateTime maturity; // maturity
    @Column(name="coupon_rate")
    private double couponRate; // Interest rate of coupon paid every 6 months（x%）
    @Column(name="total_value")
    private double totalValue; // Total value of the investment at this point (It changes whenever coupon is paid)


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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
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

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public LocalDateTime getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDateTime maturity) {
        this.maturity = maturity;
    }

    public double getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(double couponRate) {
        this.couponRate = couponRate;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
