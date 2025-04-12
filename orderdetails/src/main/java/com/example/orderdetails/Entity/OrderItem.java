package com.example.orderdetails.Entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderItemid;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(nullable = false)
    private long product_id;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    public OrderItem()
    {

    }

    public OrderItem(long orderItemid, Order order_id, long product_id, int quantity, double price) {
        this.orderItemid = orderItemid;
        this.order = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public long getOrderItemid() {
        return orderItemid;
    }

    public void setOrder(Order orderItemid) {
        this.order = orderItemid;
    }

    public Order getOrder_id() {
        return order;
    }



    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
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

}
