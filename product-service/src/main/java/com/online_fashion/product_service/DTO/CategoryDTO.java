package com.online_fashion.product_service.DTO;
import com.online_fashion.product_service.Entities.Category;

public class CategoryDTO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO(){}

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryDTO(Long id, String name){
        setId(id);
        setName(name);
    }
}
