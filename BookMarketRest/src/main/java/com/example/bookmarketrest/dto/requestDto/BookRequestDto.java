package com.example.bookmarketrest.dto.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class BookRequestDto {
    private String name;
    private List<Integer> authorIds;
    private Integer categoryId;
}
