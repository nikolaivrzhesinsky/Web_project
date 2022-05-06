package com.example.service;

import com.example.Models.CityModel;
import com.example.Models.ZipcodeModel;
import com.example.dto.requestDto.ZipcodeRequestDto;
import com.example.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZipcodeServiceImpl implements ZipcodeService {

    private final ZipcodeRepository zipcodeRepository;
    private final CityService cityService;
    @Autowired
    public ZipcodeServiceImpl(ZipcodeRepository zipcodeRepository, CityService cityService) {
        this.zipcodeRepository = zipcodeRepository;
        this.cityService= cityService;
    }

    @Transactional
    @Override
    public ZipcodeModel addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        ZipcodeModel zipcodeModel= new ZipcodeModel();
        zipcodeModel.setName(zipcodeRequestDto.getName());
        if(zipcodeRequestDto.getCityId()==null){
            return zipcodeRepository.save(zipcodeModel);
        }
        CityModel city= cityService.getCity(zipcodeRequestDto.getCityId()) ;
        zipcodeModel.setCityModel(city);
        return zipcodeRepository.save(zipcodeModel);
    }

    @Override
    public List<ZipcodeModel> getZipcodes() {
        return null;
    }

    @Override
    public ZipcodeModel getZipcode(Long zipcodeId) {
        return null;
    }

    @Override
    public ZipcodeModel deleteZipcode(Long zipcodeId) {
        return null;
    }

    @Override
    public ZipcodeModel editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
        return null;
    }

    @Override
    public ZipcodeModel addCityToZipcode(Long zipcodeId, Long cityId) {
        return null;
    }

    @Override
    public ZipcodeModel removeCityFromZipcode(Long zipcodeId) {
        return null;
    }
}
