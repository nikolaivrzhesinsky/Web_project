package com.example.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorResponseDto {
    private int id;
    private String name;
    private List<String> bookNames;
    private String zipcodeName;
}
