package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.AuthorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorModel,Integer> {
}
