package com.example.springseciritytest.repository;

import com.example.springseciritytest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}