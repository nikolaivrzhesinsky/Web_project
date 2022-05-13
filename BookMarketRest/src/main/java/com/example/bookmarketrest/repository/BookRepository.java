package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookModel,Integer> {
}
