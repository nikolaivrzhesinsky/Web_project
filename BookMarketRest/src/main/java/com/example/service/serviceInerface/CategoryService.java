package com.example.service.serviceInerface;

import com.example.Models.CategoryModel;
import com.example.dto.requestDto.CategoryRequestDto;
import com.example.dto.responseDto.CategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public CategoryModel getCategory(int categoryId);
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    public CategoryResponseDto getCategoryById(int categoryId);
    public List<CategoryResponseDto> getCategories();
    public void deleteCategory(int categoryId);
    public CategoryResponseDto editCategory(int categoryId, CategoryRequestDto categoryRequestDto);
}
