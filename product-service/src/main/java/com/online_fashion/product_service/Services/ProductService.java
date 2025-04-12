package com.online_fashion.product_service.Services;

import com.online_fashion.product_service.DTO.CategoryDTO;
import com.online_fashion.product_service.DTO.ProductDTO;
import com.online_fashion.product_service.Entities.Category;
import com.online_fashion.product_service.Entities.Product;
import com.online_fashion.product_service.Repositories.CategoryRepo;
import com.online_fashion.product_service.Repositories.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    private ProductDTO convertAndSaveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setImageUrl(productDTO.getImageUrl());

        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepo.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        Product savedProduct = productRepo.save(product);
        return mapProductToDTO(savedProduct);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        return convertAndSaveProduct(productDTO);
    }

    public List<ProductDTO> addProducts(List<ProductDTO> productDTOs) {
        return productDTOs.stream().map(this::convertAndSaveProduct).collect(Collectors.toList());
    }

    private ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(new CategoryDTO(product.getCategory()));
        }
        return productDTO;
    }

    public ProductDTO getProductById(Long id) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapProductToDTO(existingProduct);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    public String deleteProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepo.deleteById(id);
        return product.getName() + " product deleted successfully";
    }

    public List<ProductDTO> searchByKeyword(String keyword) {
        return productRepo.keyWordSearching(keyword).stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> searchByCategory(String category) {
        return productRepo.findByCategoryIgnoreCase(category).stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> filterByPrice(double price) {
        return productRepo.findAll().stream()
                .filter(product -> product.getPrice() <= price)
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }
}
