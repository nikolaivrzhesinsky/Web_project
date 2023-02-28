package com.example.catalogfilm.repository;

import com.example.catalogfilm.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectorReposytory extends JpaRepository<Director, UUID> {
}
