package com.example.repository;

import com.example.Models.CityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityModel,Integer> {
    CityModel findAllById(int cityId);
}
