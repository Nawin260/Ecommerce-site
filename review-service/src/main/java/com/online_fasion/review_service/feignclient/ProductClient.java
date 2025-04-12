package com.online_fasion.review_service.feignclient;

import com.online_fasion.review_service.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:5052/product")
public interface ProductClient {

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
