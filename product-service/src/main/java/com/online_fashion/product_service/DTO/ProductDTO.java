package com.online_fashion.product_service.DTO;

import com.online_fashion.product_service.Entities.Category;
import com.online_fashion.product_service.Entities.Product;
import org.modelmapper.ModelMapper;
import lombok.*;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Long categoryId;
    private CategoryDTO categoryDTO;
    private String imageUrl;
    //private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductDTO(){}

    public ProductDTO(long id,String name, String description, double price, int stockQuantity, CategoryDTO categoryDTO, String imageUrl) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoryDTO = categoryDTO;
        this.imageUrl = imageUrl;

    }
    public ProductDTO(Product product) {
        this.id=product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.imageUrl = product.getImageUrl();

        if (product.getCategory() != null) {
            this.categoryDTO = new CategoryDTO(product.getCategory());
        }
    }

}
