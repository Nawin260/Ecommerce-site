package com.example.orderdetails.DTO;

import com.example.orderdetails.Entity.Order;
import com.example.orderdetails.Enumm.Status;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private long id;
    private double total_amount;
    private Status status;
    private long userid;


    public OrderDTO()
    {

    }

    public OrderDTO(long userid, long id,double total_amount, Status status) {
        this.userid=userid;
        this.id=id;
        this.total_amount = total_amount;
        this.status = status;
    }

    public OrderDTO(Order order)
    {
        this.id=order.getId();
        this.userid=order.getUserNumber();
        this.status=order.getStatus();
        this.total_amount=order.getTotal_amount();
       //this.items = order.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }



    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
