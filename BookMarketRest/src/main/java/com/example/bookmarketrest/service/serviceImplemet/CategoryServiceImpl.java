package com.example.bookmarketrest.service.serviceImplemet;

import com.example.bookmarketrest.Models.CategoryModel;
import com.example.bookmarketrest.dto.mapperUtil;
import com.example.bookmarketrest.dto.requestDto.CategoryRequestDto;
import com.example.bookmarketrest.dto.responseDto.CategoryResponseDto;
import com.example.bookmarketrest.repository.CategoryRepository;
import com.example.bookmarketrest.service.serviceInerface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
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
    public CategoryResponseDto getCategoryById(int categoryId) {

        CategoryModel categoryModel=getCategory(categoryId);
        return mapperUtil.categoryToCategoryResponseDto(categoryModel);
    }

    @Override
    public List<CategoryResponseDto> getCategories() {

        List<CategoryModel> categoryModels=(List<CategoryModel>) categoryRepository.findAll();
        return mapperUtil.categoriesToCategoryResponseDtoList(categoryModels);
    }

    @Override
    public CategoryResponseDto deleteCategory(int categoryId) {

        CategoryModel categoryModel=getCategory(categoryId);
        categoryRepository.delete(categoryModel);
        return mapperUtil.categoryToCategoryResponseDto(categoryModel);
    }

    @Transactional
    @Override
    public CategoryResponseDto editCategory(int categoryId, CategoryRequestDto categoryRequestDto) {

        CategoryModel categoryModel=getCategory(categoryId);
        categoryModel.setName(categoryRequestDto.getName());
        return mapperUtil.categoryToCategoryResponseDto(categoryModel);
    }
}
