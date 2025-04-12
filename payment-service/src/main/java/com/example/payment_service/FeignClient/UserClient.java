package com.example.payment_service.FeignClient;

import com.example.payment_service.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="userdetails",url="http://localhost:5051/api/user")
public interface UserClient {

    @GetMapping("getById/{userid}")
    UserDTO getUserById(@PathVariable long userid);

}