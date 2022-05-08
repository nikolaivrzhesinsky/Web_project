package com.example.service.serviceImplemet;

import com.example.Models.CityModel;
import com.example.Models.ZipcodeModel;
import com.example.dto.requestDto.ZipcodeRequestDto;
import com.example.repository.ZipcodeRepository;
import com.example.service.serviceInerface.CityService;
import com.example.service.serviceInerface.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Objects;

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
    public Iterable<ZipcodeModel> getZipcodes() {
        return zipcodeRepository.findAll();
    }

    @Override
    public ZipcodeModel getZipcode(int zipcodeId) {
        return zipcodeRepository.findById(zipcodeId).orElseThrow(() ->
                new IllegalArgumentException(
                        "zipcode with id: " + zipcodeId + " could not be found"));
    }

    @Override
    public void deleteZipcode(int zipcodeId) {
        zipcodeRepository.deleteById(zipcodeId);
    }

    @Transactional
    @Override
    public ZipcodeModel editZipcode(int zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {

        ZipcodeModel zipcodeToEdit = getZipcode(zipcodeId);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() != null) {
            return zipcodeToEdit;
        }
        CityModel city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcodeToEdit.setCityModel(city);
        return zipcodeToEdit;
    }

    @Transactional
    @Override
    public ZipcodeModel addCityToZipcode(int zipcodeId, int cityId) {
        ZipcodeModel zipcodeModel=getZipcode(zipcodeId);
        CityModel cityModel=cityService.getCity(cityId);
        if (Objects.nonNull(zipcodeModel.getCityModel())) {
            throw new IllegalArgumentException("zipcode already has a city");
        }
        zipcodeModel.setCityModel(cityModel);
        return zipcodeModel;
    }

    @Override
    public ZipcodeModel removeCityFromZipcode(int zipcodeId) {
        ZipcodeModel zipcode = getZipcode(zipcodeId);
        if (!Objects.nonNull(zipcode.getCityModel())) {
            throw new IllegalArgumentException("zipcode does not have a city");
        }
        zipcode.setCityModel(null);
        return null;
    }
}
