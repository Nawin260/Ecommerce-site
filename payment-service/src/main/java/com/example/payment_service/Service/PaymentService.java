package com.example.payment_service.Service;

import com.example.payment_service.DTO.OrderDTO;
import com.example.payment_service.DTO.PaymentDTO;
import com.example.payment_service.DTO.PaymentRequestDTO;
import com.example.payment_service.Entity.Payment;
import com.example.payment_service.Enum.PaymentMethod;
import com.example.payment_service.Enum.Status;
import com.example.payment_service.FeignClient.OrderClient;
import com.example.payment_service.FeignClient.UserClient;
import com.example.payment_service.Repo.PaymentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    UserClient userClient;

    @Autowired
    OrderClient orderClient;

    @Autowired
    ModelMapper modelMapper;


//    public List<PaymentDTO> payMoney(List<PaymentDTO> paymentDTO) {
//            List<Payment> paymentList=paymentDTO
//                    .stream()
//                    .map(dto -> {
//                        Payment payment = modelMapper.map(dto, Payment.class);
//                        payment.setCreatedAt(LocalDateTime.now()); // Set the createdAt field
//                        return payment;
//                    })
//                    .collect(Collectors.toList());
//
//            List<Payment> payment=paymentRepo.saveAll(paymentList);
//
//            return payment.stream()
//                    .map(entity->modelMapper.map(entity,PaymentDTO.class))
//                    .collect(Collectors.toList());
//
//    }

    public PaymentDTO placePayment(PaymentRequestDTO paymentRequest) {
        OrderDTO order = orderClient.getOrderById(paymentRequest.getOrderId());
        double amount = order.getTotal_amount();
        long userId = order.getUserid();

        PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentRequest.getPaymentMethod().toLowerCase());

        Payment payment = new Payment();
        payment.setOrderID(paymentRequest.getOrderId());
        payment.setUserID(userId);
        payment.setAmount(amount);
        payment.setStatus(Status.Pending);
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionID(generateTransactionID());
        payment.setCreatedAt(LocalDateTime.now());

        Payment savedPayment = paymentRepo.save(payment);
        return modelMapper.map(savedPayment, PaymentDTO.class);
    }

    private long generateTransactionID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public List<PaymentDTO> getByUser(long userID) {
        List<Payment> payments = paymentRepo.findByUserID(userID);
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    public List<PaymentDTO> getByOrder(long orderID) {
        List<Payment> payments = paymentRepo.findByOrderID(orderID);
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }
}
