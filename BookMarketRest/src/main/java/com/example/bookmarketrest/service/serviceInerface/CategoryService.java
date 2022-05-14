package com.example.bookmarketrest.service.serviceInerface;

import com.example.bookmarketrest.Models.CategoryModel;
import com.example.bookmarketrest.dto.requestDto.CategoryRequestDto;
import com.example.bookmarketrest.dto.responseDto.CategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public CategoryModel getCategory(int categoryId);
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    public CategoryResponseDto getCategoryById(int categoryId);
    public List<CategoryResponseDto> getCategories();
    public CategoryResponseDto deleteCategory(int categoryId);
    public CategoryResponseDto editCategory(int categoryId, CategoryRequestDto categoryRequestDto);
}
