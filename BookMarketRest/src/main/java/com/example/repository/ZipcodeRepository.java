package com.example.repository;

import com.example.Models.ZipcodeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends CrudRepository<ZipcodeModel,Integer> {
}
