package com.example.orderdetails.Kafka;

import com.example.orderdetails.DTO.OrderRequestDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consumeOrder(OrderRequestDTO order) {
        System.out.println("Consumed order: " + order);
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed"+order);
    }
}
