package com.example.repository;

import com.example.Models.AuthorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorModel,Integer> {
}
