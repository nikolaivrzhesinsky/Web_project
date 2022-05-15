package com.example.bookmarketrest.repository;

import com.example.bookmarketrest.Models.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityModel,Integer> {
    CityModel findAllById(int cityId);

    public CityModel findCityModelByName(String name);
}
