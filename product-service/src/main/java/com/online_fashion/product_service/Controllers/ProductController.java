package com.online_fashion.product_service.Controllers;

import com.online_fashion.product_service.DTO.ProductDTO;
import com.online_fashion.product_service.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<ProductDTO>> addProducts(@RequestBody List<ProductDTO> productDTOs) {
        return ResponseEntity.ok(productService.addProducts(productDTOs));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<List<ProductDTO>> withKeyWords(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchByKeyword(keyword));
    }

    // FIXED: Changed "/{category}" to "/category/{category}"
    @GetMapping("/category")
    public ResponseEntity<List<ProductDTO>> withCategory(@RequestParam String category) {
        return ResponseEntity.ok(productService.searchByCategory(category));
    }

    @GetMapping("/filterByPrice")
    public ResponseEntity<List<ProductDTO>> byPriceRange(@RequestParam double price) {
        return ResponseEntity.ok(productService.filterByPrice(price));
    }
}
