package com.example.service.serviceImplemet;

import com.example.Models.AuthorModel;
import com.example.Models.BookModel;
import com.example.dto.mapperUtil;
import com.example.dto.requestDto.BookRequestDto;
import com.example.dto.responseDto.BookResponseDto;
import com.example.repository.BookRepository;
import com.example.service.serviceInerface.AuthorService;
import com.example.service.serviceInerface.BookService;
import com.example.service.serviceInerface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Transactional
    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        BookModel bookModel=new BookModel();
        bookModel.setName(bookRequestDto.getName());

        if(bookRequestDto.getAuthorIds().isEmpty()){
            throw  new IllegalArgumentException("Have to be at least one author");
        }
        else{
            List<AuthorModel>authorModels= new ArrayList<>();
            for (int authorId : bookRequestDto.getAuthorIds()) {
                authorModels.add(authorService.getAuthor(authorId));
            }
            bookModel.setAuthorsModelList(authorModels);
        }

        if(bookRequestDto.getCategoryId()==null){
            throw new IllegalArgumentException("have to be at least one category");
        }
        else {
            bookModel.setCategory(categoryService.getCategory(bookRequestDto.getCategoryId()));
        }
        bookRepository.save(bookModel);
        return mapperUtil.bookToBookResponseDto(bookModel);
    }

    @Override
    public BookResponseDto getBookById(int bookId) {
        return null;
    }

    @Override
    public BookModel getBook(int bookId) {
        return null;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        return null;
    }

    @Override
    public BookResponseDto deleteBook(int bookId) {
        return null;
    }

    @Override
    public BookResponseDto editBook(int bookId, BookRequestDto bookRequestDto) {
        return null;
    }

    @Override
    public BookResponseDto addAuthorToBook(int bookId, int authorId) {
        return null;
    }

    @Override
    public BookResponseDto deleteAuthorFromBook(int bookId, int authorId) {
        return null;
    }

    @Override
    public BookResponseDto addCategoryToBook(int bookId, int categoryId) {
        return null;
    }

    @Override
    public BookResponseDto removeCategoryFromBook(int bookId, int categoryId) {
        return null;
    }
}
