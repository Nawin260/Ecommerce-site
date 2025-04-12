package com.example.orderdetails.Controller;

import com.example.orderdetails.DTO.OrderDTO;
import com.example.orderdetails.DTO.OrderDisplayDTO;
import com.example.orderdetails.DTO.OrderRequestDTO;
import com.example.orderdetails.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("addOrder")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO)
    {
        return new ResponseEntity<>(orderService.addOrder(orderRequestDTO.getUserID(),orderRequestDTO.getProductID()), HttpStatus.CREATED);
    }

    @GetMapping("findall")
    public ResponseEntity<List<OrderDisplayDTO>> getAllOrders() {
        List<OrderDisplayDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("orderNum/{orderId}")
    public ResponseEntity<OrderDisplayDTO> getOrderById(@PathVariable long orderId) {
        Optional<OrderDisplayDTO> orderDTO = orderService.getOrderById(orderId);
        return orderDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
