package com.example.bookmarketrest.controllers;

import com.example.bookmarketrest.Models.ZipcodeModel;
import com.example.bookmarketrest.dto.requestDto.ZipcodeRequestDto;
import com.example.bookmarketrest.service.serviceInerface.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {
    private final ZipcodeService zipcodeService;

    @Autowired
    public ZipcodeController(ZipcodeService zipcodeService) {
        this.zipcodeService = zipcodeService;
    }

    @PostMapping("/add")
    public ResponseEntity<ZipcodeModel> addZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto) {
        ZipcodeModel zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ZipcodeModel> getZipcode(@PathVariable final int id) {
        ZipcodeModel zipcode = zipcodeService.getZipcode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ZipcodeModel>> getZipcodes() {
        List<ZipcodeModel> zipcodes = (List<ZipcodeModel>) zipcodeService.getZipcodes();
        return new ResponseEntity<>(zipcodes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ZipcodeModel> deleteZipcode(@PathVariable final int id) {
        ZipcodeModel zipcode = zipcodeService.deleteZipcode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<ZipcodeModel> editZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto,
                                               @PathVariable final int id) {
        ZipcodeModel zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
    public ResponseEntity<ZipcodeModel> addCity(@PathVariable final int cityId,
                                           @PathVariable final int zipcodeId) {
        ZipcodeModel zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/deleteCity/{zipcodeId}")
    public ResponseEntity<ZipcodeModel> deleteCity(@PathVariable final int zipcodeId) {
        ZipcodeModel zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }
}
