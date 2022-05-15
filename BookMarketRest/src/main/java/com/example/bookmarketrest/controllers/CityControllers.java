package com.example.bookmarketrest.controllers;


import com.example.bookmarketrest.Models.CityModel;
import com.example.bookmarketrest.dto.requestDto.CityRequestDto;
import com.example.bookmarketrest.service.serviceInerface.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")

public class CityControllers {

    private final CityService cityService;
    @Autowired
    public CityControllers(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<CityModel> addCity(@RequestBody final CityRequestDto cityRequestDto) {
        CityModel city = cityService.addCity(cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CityModel> getCityById(@PathVariable final int id) {
        CityModel city = cityService.getCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public  ResponseEntity<CityModel> getCityByName(@PathVariable final  String name){
        CityModel cityModel=cityService.getCityByName(name);
        return  new ResponseEntity<>(cityModel,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<CityModel>> getAllCities(){
        List<CityModel>cityModelList=cityService.getCities();
        return  new ResponseEntity<>(cityModelList,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CityModel> deleteCity(@PathVariable final int id) {
        CityModel city = cityService.deleteCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/edit/id")
    public ResponseEntity<CityModel> editCity(@RequestBody final CityRequestDto cityRequestDto, @PathVariable final int id) {
        CityModel city = cityService.editCity(id, cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }


}
