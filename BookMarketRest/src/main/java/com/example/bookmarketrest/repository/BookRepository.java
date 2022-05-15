package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.AuthorModel;
import com.example.bookmarketrest.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Integer> {

    //List<BookModel> findBookModelsByAuthorsModelList(List<AuthorModel> authorsModelList);

}
