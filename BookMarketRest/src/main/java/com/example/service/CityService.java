package com.example.service;

import com.example.Models.CityModel;
import com.example.dto.requestDto.CityRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    public CityModel addCity(CityRequestDto cityRequestDto);
    public List<CityModel> getCities();
    public CityModel getCity(int cityId);
    public CityModel deleteCity(int cityId);
    public CityModel editCity(int cityId, CityRequestDto cityRequestDto);
}
