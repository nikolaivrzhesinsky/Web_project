package com.example.service.serviceImplemet;

import com.example.Models.AuthorModel;
import com.example.Models.ZipcodeModel;
import com.example.dto.mapperUtil;
import com.example.dto.requestDto.AuthorRequestDto;
import com.example.dto.responseDto.AuthorResponseDto;
import com.example.repository.AuthorRepository;
import com.example.service.serviceInerface.AuthorService;
import com.example.service.serviceInerface.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ZipcodeService zipcodeService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ZipcodeService zipcodeService) {
        this.authorRepository = authorRepository;
        this.zipcodeService = zipcodeService;
    }

    @Transactional
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        AuthorModel author = new AuthorModel();
        author.setName(authorRequestDto.getName());
        if (authorRequestDto.getZipcodeId() == null) {
            throw new IllegalArgumentException("author need a zipcode");
        }
        ZipcodeModel zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
        author.setZipcodeModel(zipcode);
        authorRepository.save(author);
        return mapperUtil.authorToAuthorResponseDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        Iterable<AuthorModel> authorModelList=authorRepository.findAll();
        return mapperUtil.authorResponseDtoList(authorModelList) ;
    }

    @Override
    public AuthorResponseDto getAuthorById(int authorId) {
        return mapperUtil.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public AuthorModel getAuthor(int authorId) {

        return null;
    }

    @Override
    public AuthorResponseDto deleteAuthor(int authorId) {
        return null;
    }

    @Override
    public AuthorResponseDto editAuthor(int authorId, AuthorRequestDto authorRequestDto) {
        return null;
    }

    @Override
    public AuthorResponseDto addZipcodeToAuthor(int authorId, int zipcodeId) {
        return null;
    }

    @Override
    public AuthorResponseDto deleteZipcodeFromAuthor(int authorId) {
        return null;
    }
}
