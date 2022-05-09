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
import java.util.Objects;
import java.util.Optional;

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

    @Transactional
    @Override
    public AuthorResponseDto getAuthorByIdResp(int authorId) {
        return mapperUtil.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public AuthorModel getAuthor(int authorId) {
        AuthorModel author = authorRepository.findById(authorId).orElseThrow(() ->
                new IllegalArgumentException(
                        "author with id: " + authorId + " could not be found"));
        return author;
    }

    @Override
    public AuthorResponseDto deleteAuthor(int authorId) {
        AuthorModel authorModel= getAuthor(authorId);
        authorRepository.delete(authorModel);
        return mapperUtil.authorToAuthorResponseDto(authorModel);
    }

    @Transactional
    @Override
    public AuthorResponseDto editAuthor(int authorId, AuthorRequestDto authorRequestDto) {
        AuthorModel authorModel= getAuthor(authorId);
        authorModel.setName(authorRequestDto.getName());
        if (authorRequestDto.getZipcodeId() != null) {
            ZipcodeModel zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
            authorModel.setZipcodeModel(zipcode);
        }
        return mapperUtil.authorToAuthorResponseDto(authorModel);
    }

    @Transactional
    @Override
    public AuthorResponseDto addZipcodeToAuthor(int authorId, int zipcodeId) {
        AuthorModel authorModel= getAuthor(authorId);
        ZipcodeModel zipcodeModel= zipcodeService.getZipcode(zipcodeId);
        if (Objects.nonNull(authorModel.getZipcodeModel())){
            throw new RuntimeException("author already has a zipcode");
        }
        authorModel.setZipcodeModel(zipcodeModel);
        return mapperUtil.authorToAuthorResponseDto(authorModel);
    }

    @Transactional
    @Override
    public AuthorResponseDto deleteZipcodeFromAuthor(int authorId) {
        AuthorModel authorModel= getAuthor(authorId);
        authorModel.setZipcodeModel(null);
        return mapperUtil.authorToAuthorResponseDto(authorModel);
    }
}
