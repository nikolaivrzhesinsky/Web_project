package com.example.service.serviceImplemet;

import com.example.Models.CategoryModel;
import com.example.dto.mapperUtil;
import com.example.dto.requestDto.CategoryRequestDto;
import com.example.dto.responseDto.CategoryResponseDto;
import com.example.repository.CategoryRepository;
import com.example.service.serviceInerface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryModel getCategory(int categoryId) {
        Optional<CategoryModel> categoryModel= categoryRepository.findById(categoryId);
        return categoryModel.orElseThrow(() -> new IllegalArgumentException("could not find category with id: "+ categoryId));
    }

    @Override
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setName(categoryRequestDto.getName());
        categoryRepository.save(categoryModel);
        return mapperUtil.categoryToCategoryResponseDto(categoryModel);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryResponseDto> getCategories() {
        return null;
    }

    @Override
    public CategoryResponseDto deleteCategory(Long categoryId) {
        return null;
    }

    @Override
    public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
        return null;
    }
}
