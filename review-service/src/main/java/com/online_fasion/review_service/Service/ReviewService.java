package com.online_fasion.review_service.Service;

import com.online_fasion.review_service.DTO.ProductDTO;
import com.online_fasion.review_service.DTO.ReviewDTO;
import com.online_fasion.review_service.DTO.UserDTO;
import com.online_fasion.review_service.Entity.Review;
import com.online_fasion.review_service.Repositories.ReviewRepo;
import com.online_fasion.review_service.feignclient.ProductClient;
import com.online_fasion.review_service.feignclient.UserClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private  ReviewRepo reviewRepository;

    @Autowired
    private  ModelMapper modelMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        System.out.println("Fetching user with ID: " + reviewDTO.getUserId());
        UserDTO userDTO = userClient.getUserById(reviewDTO.getUserId());
        System.out.println("Fetched User: " + userDTO);

        if (userDTO == null) {
            throw new RuntimeException("User not found");
        }

        System.out.println("Fetching product with ID: " + reviewDTO.getProductId());
        ProductDTO productDTO = productClient.getProductById(reviewDTO.getProductId());
        System.out.println("Fetched Product: " + productDTO);

        if (productDTO == null) {
            throw new RuntimeException("Product not found");
        }

        Review review = modelMapper.map(reviewDTO, Review.class);
        review.setUserId(userDTO.getUserid());
        review.setProductId(productDTO.getId());
        review.setCreatedAt(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);
        return modelMapper.map(savedReview, ReviewDTO.class);
    }


    public List<ReviewDTO> getReviewsByProduct(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
