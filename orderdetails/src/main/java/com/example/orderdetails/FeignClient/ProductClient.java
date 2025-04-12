package com.example.orderdetails.FeignClient;

import com.example.orderdetails.DTO.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service",url="http://localhost:5052/product")

public interface ProductClient {

    @GetMapping("/{id}")
    ProductDto getProductById(@PathVariable Long id);
}