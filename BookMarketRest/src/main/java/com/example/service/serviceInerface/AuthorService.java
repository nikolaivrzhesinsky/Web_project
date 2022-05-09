package com.example.service.serviceInerface;


import com.example.Models.AuthorModel;
import com.example.dto.requestDto.AuthorRequestDto;
import com.example.dto.responseDto.AuthorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
