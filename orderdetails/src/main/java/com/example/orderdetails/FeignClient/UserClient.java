package com.example.orderdetails.FeignClient;

import com.example.orderdetails.DTO.UserDTO;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="userdetails",url="http://localhost:5051/api/user")
public interface UserClient {

    @GetMapping("getById/{userid}")
    UserDTO getUserById(@PathVariable long userid);

}
