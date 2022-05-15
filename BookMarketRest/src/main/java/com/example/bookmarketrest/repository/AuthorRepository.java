package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel,Integer> {

    @Query(value = "select u from AuthorModel u where u.name = ?1")
    public Optional<AuthorModel> findByName(String name);
}
