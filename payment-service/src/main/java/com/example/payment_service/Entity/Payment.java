package com.example.payment_service.Entity;

import com.example.payment_service.Enum.PaymentMethod;
import com.example.payment_service.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payID;

    @Column(nullable = false)
    private long orderID;

    @Column(nullable = false)
    private long userID;

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private long transactionID;

    private LocalDateTime createdAt;

    public Payment()
    {

    }

    public Payment(long payID, long orderID, long userID, double amount, Status status, PaymentMethod paymentMethod, long transactionID, LocalDateTime createdAt) {
        this.payID = payID;
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.transactionID = transactionID;
        this.createdAt = createdAt;
    }

    public long getPayID() {
        return payID;
    }

    public void setPayID(long payID) {
        this.payID = payID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
