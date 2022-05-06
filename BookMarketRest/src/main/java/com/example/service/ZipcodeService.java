package com.example.service;

import com.example.Models.ZipcodeModel;
import com.example.dto.requestDto.ZipcodeRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZipcodeService {
    public ZipcodeModel addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    public List<ZipcodeModel> getZipcodes();
    public ZipcodeModel getZipcode(Long zipcodeId);
    public ZipcodeModel deleteZipcode(Long zipcodeId);
    public ZipcodeModel editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    public ZipcodeModel addCityToZipcode(Long zipcodeId, Long cityId);
    public ZipcodeModel removeCityFromZipcode(Long zipcodeId);
}
