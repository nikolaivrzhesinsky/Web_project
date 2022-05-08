package com.example.service.serviceInerface;

import com.example.Models.ZipcodeModel;
import com.example.dto.requestDto.ZipcodeRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ZipcodeService {
    public ZipcodeModel addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    public Iterable<ZipcodeModel> getZipcodes();
    public ZipcodeModel getZipcode(int zipcodeId);
    public void deleteZipcode(int zipcodeId);
    public ZipcodeModel editZipcode(int zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    public ZipcodeModel addCityToZipcode(int zipcodeId, int cityId);
    public ZipcodeModel removeCityFromZipcode(int zipcodeId);
}
