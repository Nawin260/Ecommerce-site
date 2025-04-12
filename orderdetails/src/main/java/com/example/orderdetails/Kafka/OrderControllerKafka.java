package com.example.orderdetails.Kafka;

import com.example.orderdetails.DTO.OrderDTO;
import com.example.orderdetails.DTO.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerKafka {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/kafka")
    public void createOrder(@RequestBody OrderRequestDTO order) {
        orderProducer.sendOrder(order);
    }
}
