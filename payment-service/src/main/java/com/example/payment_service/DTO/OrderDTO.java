package com.example.payment_service.DTO;

public class OrderDTO {
    private long id;
    private long userid;
    private double total_amount;

    public OrderDTO()
    {

    }
    public OrderDTO(long id, long userid,double total_amount) {
        this.id = id;
        this.userid=userid;
        this.total_amount = total_amount;
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

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
