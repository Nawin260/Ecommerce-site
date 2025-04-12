package com.online_fashion.product_service.Repositories;

import com.online_fashion.product_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> keyWordSearching(String keyword);

    @Query("SELECT p FROM Product p WHERE LOWER(p.category.name) = LOWER(:category)")
    List<Product> findByCategoryIgnoreCase(String category);

}
