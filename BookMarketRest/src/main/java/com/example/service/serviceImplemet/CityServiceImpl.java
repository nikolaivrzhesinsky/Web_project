package com.example.service.serviceImplemet;

import com.example.Models.CityModel;
import com.example.dto.requestDto.CityRequestDto;
import com.example.repository.CityRepository;
import com.example.service.serviceInerface.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    @Override
    public CityModel addCity(CityRequestDto cityRequestDto) {
        CityModel cityModel= new CityModel();
        cityModel.setName(cityRequestDto.getName());
        return cityRepository.save(cityModel);
    }

    @Override
    public List<CityModel> getCities() {
//        List<CityModel>cityModelList= new ArrayList<>();
//        cityRepository.findAll().forEach(cityModelList::add);
//        return cityModelList;

        return (List<CityModel>) cityRepository.findAll();
    }

    @Override
    public CityModel getCity(int cityId) {

        return cityRepository.findById(cityId).orElseThrow(() ->
                new IllegalArgumentException("city with cityId: " + cityId + " could not be found"));
    }

    @Override
    public CityModel deleteCity(int cityId) {
        CityModel cityModel= new CityModel();
        cityRepository.deleteById(cityId);
        return null;
    }

    @Transactional
    @Override
    public CityModel editCity(int cityId, CityRequestDto cityRequestDto) {
        CityModel cityEdit=getCity(cityId);
        cityEdit.setName(cityRequestDto.getName());
        return cityEdit;
    }
}
