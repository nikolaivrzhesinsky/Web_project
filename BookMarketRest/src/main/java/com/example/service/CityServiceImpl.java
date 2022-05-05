package com.example.service;

import com.example.Models.CityModel;
import com.example.dto.requestDto.CityRequestDto;
import com.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityModel addCity(CityRequestDto cityRequestDto) {
        CityModel cityModel= new CityModel();
        cityModel.setName(cityRequestDto.getName());
        return cityRepository.save(cityModel);
    }

    @Override
    public List<CityModel> getCities() {
        List<CityModel>cityModelList= new ArrayList<>();
        cityRepository.findAll().forEach(cityModelList::add);
        return cityModelList;
//        Iterable<CityModel> cityModelList= new ArrayList<>();
//        cityModelList=cityRepository.findAll();
//        return (List<CityModel>) cityModelList;
    }

    @Override
    public CityModel getCity(int cityId) {
        return null;
    }

    @Override
    public CityModel deleteCity(int cityId) {
        return null;
    }

    @Override
    public CityModel editCity(int cityId, CityRequestDto cityRequestDto) {
        return null;
    }
}
