package com.online_fasion.review_service.Repositories;

import com.online_fasion.review_service.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByProductId(Long productId);
}
