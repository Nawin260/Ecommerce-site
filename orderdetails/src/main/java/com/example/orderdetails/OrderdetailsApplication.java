package com.example.orderdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderdetailsApplication.class, args);
	}

}
