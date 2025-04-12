package com.example.orderdetails.DTO;

import com.example.orderdetails.Entity.Order;
import com.example.orderdetails.Enumm.Status;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDisplayDTO {
    private long userIDNum;

    private String userName;
    private long id;
    private double total_amount;
    private Status status;
    private List<OrderItemDTO> items;

    public OrderDisplayDTO()
    {

    }

    public OrderDisplayDTO(long userIDNum,String userName, long id, double total_amount, Status status, List<OrderItemDTO> items) {
        this.userIDNum = userIDNum;

        this.userName = userName;
        this.id = id;
        this.total_amount = total_amount;
        this.status = status;
        this.items = items;
    }

    public OrderDisplayDTO(Order order)
    {

        this.status=order.getStatus();
        this.total_amount=order.getTotal_amount();
        this.items = order.getItems().stream()
                .map(orderItem -> {
                    OrderItemDTO dto = new OrderItemDTO(orderItem);
                    dto.setProductID(orderItem.getProduct_id());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public long getUserIDNum() {
        return userIDNum;
    }

    public void setUserIDNum(long userIDNum) {
        this.userIDNum = userIDNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }



    @Override
    public String toString() {
        return "OrderDisplayDTO{" +
                "userIDNum=" + userIDNum +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", total_amount=" + total_amount +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}
