package com.example.bookmarketrest.service.serviceInerface;


import com.example.bookmarketrest.Models.AuthorModel;
import com.example.bookmarketrest.dto.requestDto.AuthorRequestDto;
import com.example.bookmarketrest.dto.responseDto.AuthorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    public List<AuthorResponseDto> getAuthors();
    public AuthorResponseDto getAuthorByIdResp(int authorId);
    public AuthorModel getAuthor(int authorId);
    public AuthorResponseDto deleteAuthor(int authorId);
    public AuthorResponseDto editAuthor(int authorId, AuthorRequestDto authorRequestDto);
    public AuthorResponseDto addZipcodeToAuthor(int authorId, int zipcodeId);
    public AuthorResponseDto deleteZipcodeFromAuthor(int authorId);
}
