package com.example.bookmarketrest.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class BookResponseDto {
    private int id;
    private String name;
    private List<String> authorNames;
    private String categoryName;
}
