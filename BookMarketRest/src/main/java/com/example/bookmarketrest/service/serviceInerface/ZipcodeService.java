package com.example.bookmarketrest.service.serviceInerface;

import com.example.bookmarketrest.Models.ZipcodeModel;
import com.example.bookmarketrest.dto.requestDto.ZipcodeRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ZipcodeService {
    public ZipcodeModel addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    public Iterable<ZipcodeModel> getZipcodes();
    public ZipcodeModel getZipcode(int zipcodeId);
    public ZipcodeModel deleteZipcode(int zipcodeId);
    public ZipcodeModel editZipcode(int zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    public ZipcodeModel addCityToZipcode(int zipcodeId, int cityId);
    public ZipcodeModel removeCityFromZipcode(int zipcodeId);
}
