package com.online_fasion.review_service.feignclient;

import com.online_fasion.review_service.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="userdetails",url="http://localhost:5051/api/user")
public interface UserClient {
    @GetMapping("getById/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
