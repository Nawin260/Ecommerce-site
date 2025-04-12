package com.example.orderdetails.DTO;

import com.example.orderdetails.Entity.Order;
import com.example.orderdetails.Entity.OrderItem;

public class OrderItemDTO {


    private long productID;
    private int quantity;
    private double price;
    private Order order;

    public OrderItemDTO()
    {

    }
    public OrderItemDTO(long productID, int quantity, double price) {

        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }



    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public OrderItemDTO(OrderItem orderItem)
    {

        this.price=orderItem.getPrice();
        this.productID=orderItem.getProduct_id();
        this.quantity=orderItem.getQuantity();


    }
}
