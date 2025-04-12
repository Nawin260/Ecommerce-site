package com.example.payment_service.DTO;

import com.example.payment_service.Enum.PaymentMethod;
import com.example.payment_service.Enum.Status;

public class PaymentDTO {

    private long payID;
    private long orderID;
    private long userID;
    private double amount;
    private Status status;
    private PaymentMethod paymentMethod;
    private long transactionID;

    public PaymentDTO()
    {

    }

    public PaymentDTO(long payID, long orderID, long userID, double amount, Status status, PaymentMethod paymentMethod, long transactionID) {
        this.payID = payID;
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.transactionID = transactionID;
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
}
