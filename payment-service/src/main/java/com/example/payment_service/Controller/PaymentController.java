package com.example.payment_service.Controller;

import com.example.payment_service.DTO.PaymentDTO;
import com.example.payment_service.DTO.PaymentRequestDTO;
import com.example.payment_service.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payMoney")
    public PaymentDTO payMoney(@RequestBody PaymentRequestDTO paymentRequest) {
        return paymentService.placePayment(paymentRequest);
    }

    @GetMapping("user/{userID}")
    public List<PaymentDTO> getByUser(@PathVariable long userID) {
        return paymentService.getByUser(userID);
    }

    @GetMapping("order/{orderID}")
    public List<PaymentDTO> getByOrder(@PathVariable long orderID) {
        return paymentService.getByOrder(orderID);
    }


}
