package com.example.orderdetails.Repo;

import com.example.orderdetails.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReo extends JpaRepository<Order,Long> {

}
