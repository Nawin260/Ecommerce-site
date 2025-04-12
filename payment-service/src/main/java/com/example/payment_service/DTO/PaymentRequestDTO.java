package com.example.payment_service.DTO;

public class PaymentRequestDTO {
    private long orderId;
    private String paymentMethod;

    public PaymentRequestDTO()
    {

    }

    public PaymentRequestDTO(long orderId, String paymentMethod) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
