package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel,Integer> {
}
