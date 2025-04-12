package com.example.orderdetails.Service;

import com.example.orderdetails.DTO.*;
import com.example.orderdetails.Entity.Order;
import com.example.orderdetails.Entity.OrderItem;
import com.example.orderdetails.Enumm.Status;
import com.example.orderdetails.FeignClient.ProductClient;
import com.example.orderdetails.FeignClient.UserClient;
import com.example.orderdetails.Repo.OrderItemRepo;
import com.example.orderdetails.Repo.OrderReo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderReo orderReo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductClient productClient;

    @Transactional
    public OrderDTO addOrder(Long userId, List<Long> productIds) {
        double totalAmount = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();

        UserDTO user = userClient.getUserById(userId);

        Order order = new Order();
        order.setUserNumber(userId);
        order.setStatus(Status.Pending);
        order.setCreated_at(LocalDateTime.now());
        Order savedOrder = orderReo.save(order);


        for (Long productId : productIds) {

            ProductDto product = productClient.getProductById(productId);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct_id(productId);
            orderItem.setQuantity(1);
            orderItem.setPrice(product.getPrice());
            orderItems.add(orderItem);
            totalAmount += product.getPrice();
            orderItemRepo.save(orderItem);
        }


        savedOrder.setTotal_amount(totalAmount);
        orderReo.save(savedOrder);

        return new OrderDTO(savedOrder);
    }


    public List<OrderDisplayDTO> getAllOrders() {
        return orderReo.findAll().stream()
                .map(order -> {
                    OrderDisplayDTO orderDisplayDTO = modelMapper.map(order, OrderDisplayDTO.class);
                    long userNumber = order.getUserNumber();
                    UserDTO user = userClient.getUserById(userNumber);
                    orderDisplayDTO.setUserName(user.getName());
                    orderDisplayDTO.setUserIDNum(user.getUserid());

                    // Map OrderItems to OrderItemDTOs
                    List<OrderItemDTO> itemDTOs = order.getItems().stream()
                            .map(orderItem -> {
                                OrderItemDTO dto = new OrderItemDTO(orderItem);
                                ProductDto productDto = productClient.getProductById(orderItem.getProduct_id());
                                dto.setProductID(productDto.getId());
                                return dto;
                            })
                            .collect(Collectors.toList());

                    orderDisplayDTO.setItems(itemDTOs);

                    return orderDisplayDTO;
                })
                .collect(Collectors.toList());
    }

    public Optional<OrderDisplayDTO> getOrderById(long orderId) {
        Optional<Order> order = orderReo.findById(orderId);
        Optional<OrderItem> orderItem = orderItemRepo.findById(orderId);

        if (order.isPresent()) {
            Order foundOrder = order.get();
            OrderDisplayDTO orderDisplayDTO = modelMapper.map(foundOrder, OrderDisplayDTO.class);

            long userNumber = foundOrder.getUserNumber();
            UserDTO user = userClient.getUserById(userNumber);
            orderDisplayDTO.setUserName(user.getName());
            orderDisplayDTO.setUserIDNum(user.getUserid());


            List<OrderItemDTO> itemDTOs = foundOrder.getItems().stream()
                    .map(orderItems -> {
                        OrderItemDTO dto = new OrderItemDTO(orderItems);
                        ProductDto productDto = productClient.getProductById(orderItems.getProduct_id());
                        dto.setProductID(productDto.getId());
                        return dto;
                    })
                    .collect(Collectors.toList());

            orderDisplayDTO.setItems(itemDTOs);
            return Optional.of(orderDisplayDTO);
        } else {
            return Optional.empty();
        }
    }

}




