package com.example.orderdetails.DTO;

import java.util.List;

public class OrderRequestDTO {
    private long userID;
    private List<Long> productID;

    public OrderRequestDTO()
    {

    }

    public OrderRequestDTO(long userID, List<Long> productID) {
        this.userID = userID;
        this.productID = productID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<Long> getProductID() {
        return productID;
    }

    public void setProductID(List<Long> productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "OrderRequestDTO{" +
                "userID=" + userID +
                ", productID=" + productID +
                '}';
    }
}
