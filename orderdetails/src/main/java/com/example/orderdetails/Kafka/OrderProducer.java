package com.example.orderdetails.Kafka;

import com.example.orderdetails.DTO.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final String TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, OrderRequestDTO> kafkaTemplate;

    public void sendOrder(OrderRequestDTO order) {
        kafkaTemplate.send(TOPIC, order);
    }
}
