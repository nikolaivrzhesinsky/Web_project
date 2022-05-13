package com.example.bookmarketrest.dto.responseDto;

import lombok.Data;

import java.util.List;

    @Data
    public class CategoryResponseDto {
        private int id;
        private String name;
        private List<String> bookNames;
    }

