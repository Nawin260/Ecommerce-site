package com.example.payment_service.FeignClient;

import com.example.payment_service.DTO.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="orderdetails",url="http://localhost:5053/api/order")
public interface OrderClient {

    @GetMapping("orderNum/{orderId}")
    OrderDTO getOrderById(@PathVariable long orderId);

}
