package com.online_fashion.product_service.Services;

import com.online_fashion.product_service.DTO.CategoryDTO;
import com.online_fashion.product_service.Entities.Category;
import com.online_fashion.product_service.Repositories.CategoryRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepo.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
                            .collect(Collectors.toList());
        return categoryDTOS;
    }

    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isEmpty()){
            throw new RuntimeException("category id not found");
        }
        return modelMapper.map(category, CategoryDTO.class);
    }
}
